package io.consentric.connector.client.citizensService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {
    private final String streetAddress;
    private final String streetAddress2;
    private final String streetAddress3;
    private final String addressLocality;
    private final String addressRegion;
    private final String addressCountry;
    private final String postalCode;
    private final String postOfficeBoxNumber;

    @JsonCreator
    public AddressDTO(@JsonProperty("streetAddress") String streetAddress,
                      @JsonProperty("streetAddress2") String streetAddress2,
                      @JsonProperty("streetAddress3") String streetAddress3,
                      @JsonProperty("addressLocality") String addressLocality,
                      @JsonProperty("addressRegion") String addressRegion,
                      @JsonProperty("addressCountry") String addressCountry,
                      @JsonProperty("postalCode") String postalCode,
                      @JsonProperty("postOfficeBoxNumber") String postOfficeBoxNumber) {
        this.streetAddress = streetAddress;
        this.streetAddress2 = streetAddress2;
        this.streetAddress3 = streetAddress3;
        this.addressLocality = addressLocality;
        this.addressRegion = addressRegion;
        this.addressCountry = addressCountry;
        this.postalCode = postalCode;
        this.postOfficeBoxNumber = postOfficeBoxNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPostOfficeBoxNumber() {
        return postOfficeBoxNumber;
    }
}
