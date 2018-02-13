package io.consentric.connector.service;

import io.consentric.connector.client.CitizensServiceClient;
import io.consentric.connector.client.PermissionsServiceClient;
import io.consentric.connector.client.permissionsService.TransactionsDTO;
import io.consentric.connector.persistence.CitizenConsentsPersistenceHandler;
import io.consentric.connector.client.converter.CitizenConsentConverter;
import io.consentric.connector.persistence.CitizenDetailsPersistenceHandler;
import io.consentric.connector.service.model.CitizenConsentStatus;
import io.consentric.connector.service.model.CitizenDetails;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.consentric.connector.client.converter.CitizenConsentConverter.fromTransactionList;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ConnectorService {

    private static final Logger log = getLogger(ConnectorService.class);

    @Autowired
    private CitizenConsentsPersistenceHandler citizenConsentsPersistenceHandler;

    @Autowired
    private CitizenDetailsPersistenceHandler citizenDetailsPersistenceHandler;

    @Autowired
    private CitizensServiceClient citizensServiceClient;

    @Autowired
    private PermissionsServiceClient permissionsServiceClient;

    @Scheduled(cron = "${consentric.transactions.updateCron:0 0/5 * * * *}")
    public void processTransactions() throws Exception {
        log.info("Checking for new transactions");

        List<CitizenConsentStatus> citizenConsentStatuses = permissionsServiceClient.getTransactions();

        citizenConsentStatuses.forEach(this::processConsentStatus);
    }

    private void processConsentStatus(CitizenConsentStatus status)  {
        CitizenConsentStatus exists = citizenConsentsPersistenceHandler.findByCitizenIdAndOptionId(status.getCitizenId(), status.getOptionId());
        CitizenDetails detailsExists = citizenDetailsPersistenceHandler.findOne(status.getCitizenId());

        if (exists == null) {
            citizenConsentsPersistenceHandler.save(status);
        } else {
            if (exists.getObtainedAt().isBefore(status.getObtainedAt())) {
                status.setId(exists.getId());
                citizenConsentsPersistenceHandler.save(status);
            }
        }

        if (detailsExists == null) {
            try {
                citizenDetailsPersistenceHandler.save(citizensServiceClient.getDetailsForCitizen(status.getCitizenId()));
            } catch (Exception ex) {
                log.info("Error retrieving citizen details: ", ex);
            }
        }
    }
}
