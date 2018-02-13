package io.consentric.connector.client.citizensService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitizenDTO {
    private final String citizenId;
    private final List<ApplicationDetailsDTO> applicationDetails;

    @JsonCreator
    public CitizenDTO(@JsonProperty("citizenId") String citizenId,
                      @JsonProperty("applicationDetails") List<ApplicationDetailsDTO> applicationDetails) {
        this.citizenId = citizenId;
        this.applicationDetails = applicationDetails;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public List<ApplicationDetailsDTO> getApplicationDetails() {
        return applicationDetails;
    }
}
