package io.consentric.connector.persistence;

import io.consentric.connector.service.model.CitizenDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CitizenDetailsPersistenceHandler extends CrudRepository<CitizenDetails, String> {
}
