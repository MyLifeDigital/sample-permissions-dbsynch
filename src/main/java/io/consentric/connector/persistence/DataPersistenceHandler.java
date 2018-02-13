package io.consentric.connector.persistence;

import io.consentric.connector.client.permissionsService.DataDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DataPersistenceHandler extends CrudRepository<DataDTO, String> {
}
