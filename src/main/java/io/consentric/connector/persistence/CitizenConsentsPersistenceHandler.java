package io.consentric.connector.persistence;

import io.consentric.connector.service.model.CitizenConsentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CitizenConsentsPersistenceHandler extends CrudRepository<CitizenConsentStatus, String> {
    CitizenConsentStatus findByCitizenIdAndOptionId(String citizenId, String optionId);
}
