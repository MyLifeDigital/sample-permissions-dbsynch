package io.consentric.connector.persistence;

import io.consentric.connector.client.permissionsService.PurposeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PurposePersistenceHandler extends CrudRepository<PurposeDTO, String> {
}
