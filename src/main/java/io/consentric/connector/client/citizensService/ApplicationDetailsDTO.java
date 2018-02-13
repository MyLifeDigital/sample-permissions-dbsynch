package io.consentric.connector.client.citizensService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDetailsDTO {
    private final String applicationId;
    private final String externalRef;
    private final String organisationName;
    private final String email;
    private final String telephone;
    private final String givenName;
    private final String additionalName;
    private final String familyName;
    private final AddressDTO address;

    @JsonCreator
    public ApplicationDetailsDTO(@JsonProperty("applicationId") String applicationId,
                                 @JsonProperty("externalRef") String externalRef,
                                 @JsonProperty("organisationName") String organisationName,
                                 @JsonProperty("email") String email,
                                 @JsonProperty("telephone") String telephone,
                                 @JsonProperty("givenName") String givenName,
                                 @JsonProperty("additionalName") String additionalName,
                                 @JsonProperty("familyName") String familyName,
                                 @JsonProperty("address") AddressDTO address) {
        this.applicationId = applicationId;
        this.externalRef = externalRef;
        this.organisationName = organisationName;
        this.email = email;
        this.telephone = telephone;
        this.givenName = givenName;
        this.additionalName = additionalName;
        this.familyName = familyName;
        this.address = address;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getExternalRef() {
        return externalRef;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
