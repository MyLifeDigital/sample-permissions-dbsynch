package io.consentric.connector.persistence;

import io.consentric.connector.client.permissionsService.OptionDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OptionPersistenceHandler extends CrudRepository<OptionDTO, String> {
}
