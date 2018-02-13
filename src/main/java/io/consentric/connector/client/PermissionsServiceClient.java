package io.consentric.connector.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import io.consentric.connector.client.converter.CitizenConsentConverter;
import io.consentric.connector.client.permissionsService.ConfigurationDTO;
import io.consentric.connector.client.permissionsService.TransactionsDTO;
import io.consentric.connector.persistence.DataPersistenceHandler;
import io.consentric.connector.persistence.OptionPersistenceHandler;
import io.consentric.connector.persistence.PartyPersistenceHandler;
import io.consentric.connector.persistence.PurposePersistenceHandler;
import io.consentric.connector.service.Auth0Service;
import io.consentric.connector.service.model.CitizenConsentStatus;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;

import static io.consentric.connector.utils.ParameterValidation.verifyParamNotEmpty;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PermissionsServiceClient {

    private static final Logger log = getLogger(PermissionsServiceClient.class);

    private static final String TRANSACTIONS_ENDPOINT_PROP = "consentric.transactions.endpoint";
    private static final String CONFIGURATION_ENDPOINT_PROP = "consentric.configuration.endpoint";
    private static final String APPLICATION_ID_PROP = "consentric.transactions.applicationId";

    private static final String AUTH_HEADER = "Authorization: Bearer ";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String APPLICATION_ID_FIELD = "applicationId";
    private static final String SINCE_FIELD = "since";

    private String transactionsEndpoint;
    private String configurationEndpoint;
    private String applicationId;

    @Autowired
    private Auth0Service auth0Service;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OptionPersistenceHandler optionPersistenceHandler;

    @Autowired
    private DataPersistenceHandler dataPersistenceHandler;

    @Autowired
    private PurposePersistenceHandler purposePersistenceHandler;

    @Autowired
    private PartyPersistenceHandler partyPersistenceHandler;

    private Instant lastRun;

    public PermissionsServiceClient(@Value("${" + TRANSACTIONS_ENDPOINT_PROP + "}") String transactionsEndpoint,
                                    @Value("${" + CONFIGURATION_ENDPOINT_PROP + "}") String configurationEndpoint,
                                    @Value("${"+ APPLICATION_ID_PROP + "}") String applicationId) {

        this.transactionsEndpoint = transactionsEndpoint;
        this.configurationEndpoint = configurationEndpoint;
        this.applicationId = applicationId;
        verifyParams();
    }

    public List<CitizenConsentStatus> getTransactions() throws Exception {
        TransactionsDTO transactions;

        if (lastRun == null) {
            lastRun = Instant.now();
            log.info("First run: fetching application configuration");
            persistApplicationConfig();
            log.info("First run: fetching all transactions");
            transactions = getAllTransactions();
        } else {
            log.info("Fetching all transactions since {}", lastRun);
            transactions = getLatestTransaction();
        }

        log.info("Retrieved {} transactions", transactions.getTransactions().size());
        return CitizenConsentConverter.fromTransactionList(transactions);
    }

    private void persistApplicationConfig() throws Exception {
        InputStream body = Unirest.get(configurationEndpoint)
            .header(AUTH_HEADER, auth0Service.getJwtToken())
            .queryString(APPLICATION_ID_FIELD, applicationId)
            .asBinary()
            .getBody();

        ConfigurationDTO dto = objectMapper.readValue(body, ConfigurationDTO.class);

        dataPersistenceHandler.save(dto.getData());
        purposePersistenceHandler.save(dto.getPurposes());
        partyPersistenceHandler.save(dto.getParties());
        optionPersistenceHandler.save(dto.getOptions());
    }

    private TransactionsDTO getAllTransactions() throws Exception {
        HttpResponse<InputStream> response = getStandardTransactionsRequest().asBinary();
        return convertToDTO(response.getBody());
    }

    private TransactionsDTO getLatestTransaction() throws Exception {
        HttpResponse<InputStream> response = getTimeFilteredTransactionsRequest().asBinary();
        lastRun = Instant.now();
        return convertToDTO(response.getBody());
    }

    private HttpRequest getTimeFilteredTransactionsRequest() throws Exception {
        return getStandardTransactionsRequest()
            .queryString(SINCE_FIELD, lastRun);
    }

    private HttpRequest getStandardTransactionsRequest() throws Exception {
        return Unirest.get(transactionsEndpoint)
            .header(AUTH_HEADER, auth0Service.getJwtToken())
            .header(CONTENT_TYPE_HEADER, APPLICATION_JSON)
            .queryString(APPLICATION_ID_FIELD, applicationId);
    }

    private TransactionsDTO convertToDTO(InputStream inputStream) throws Exception {
        return objectMapper.readValue(inputStream, TransactionsDTO.class);
    }

    private void verifyParams() {
        verifyParamNotEmpty(TRANSACTIONS_ENDPOINT_PROP, transactionsEndpoint, PermissionsServiceClient.class);
        verifyParamNotEmpty(CONFIGURATION_ENDPOINT_PROP, configurationEndpoint, PermissionsServiceClient.class);
        verifyParamNotEmpty(APPLICATION_ID_PROP, applicationId, PermissionsServiceClient.class);
    }
}
