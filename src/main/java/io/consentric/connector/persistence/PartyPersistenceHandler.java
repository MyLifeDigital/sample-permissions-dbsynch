package io.consentric.connector.persistence;

import io.consentric.connector.client.permissionsService.PartyDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PartyPersistenceHandler extends CrudRepository<PartyDTO, String> {
}
