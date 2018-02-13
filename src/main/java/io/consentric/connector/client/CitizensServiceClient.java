package io.consentric.connector.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import io.consentric.connector.client.citizensService.CitizenDTO;
import io.consentric.connector.service.Auth0Service;
import io.consentric.connector.service.model.CitizenDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

import static io.consentric.connector.client.converter.CitizenDetailsConverter.fromDTO;
import static io.consentric.connector.utils.ParameterValidation.verifyParamNotEmpty;

@Component
public class CitizensServiceClient {

    private static final String CITIZENS_ENDPOINT_PROP = "consentric.citizens.endpoint";

    @Autowired
    private Auth0Service auth0Service;

    @Autowired
    private ObjectMapper objectMapper;

    private String citizensEndpoint;

    public CitizensServiceClient(@Value("${" + CITIZENS_ENDPOINT_PROP + "}") String citizensEndpoint) {
        this.citizensEndpoint = citizensEndpoint;
        verifyParamNotEmpty(CITIZENS_ENDPOINT_PROP, citizensEndpoint, CitizensServiceClient.class);
    }

    public CitizenDetails getDetailsForCitizen(String citizenId) throws Exception {
        InputStream body = Unirest.get(citizensEndpoint + "/" + citizenId)
            .header("Authorization: Bearer ", auth0Service.getJwtToken())
            .header("Content-Type", "application/json")
            .asBinary()
            .getBody();

        CitizenDTO citizenDTO = convertToDTO(body);

        return fromDTO(citizenDTO);
    }

    private CitizenDTO convertToDTO(InputStream inputStream) throws Exception {
        return objectMapper.readValue(inputStream, CitizenDTO.class);
    }
}
