package io.consentric.connector.client.converter;

import io.consentric.connector.client.citizensService.AddressDTO;
import io.consentric.connector.client.citizensService.ApplicationDetailsDTO;
import io.consentric.connector.client.citizensService.CitizenDTO;
import io.consentric.connector.service.model.CitizenDetails;

public class CitizenDetailsConverter {
    private CitizenDetailsConverter() {

    }

    public static CitizenDetails fromDTO(CitizenDTO citizenDTO) {
        ApplicationDetailsDTO appDetails = citizenDTO.getApplicationDetails().get(0);
        AddressDTO address = appDetails.getAddress();
        return new CitizenDetails()
            .withCitizenId(citizenDTO.getCitizenId())
            .withExternalRef(appDetails.getExternalRef())
            .withOrganisationName(appDetails.getOrganisationName())
            .withEmail(appDetails.getEmail())
            .withTelephone(appDetails.getTelephone())
            .withGivenName(appDetails.getGivenName())
            .withAdditionalName(appDetails.getAdditionalName())
            .withFamilyName(appDetails.getFamilyName())
            .withStreetAddress(address.getStreetAddress())
            .withStreetAddress2(address.getStreetAddress2())
            .withStreetAddress3(address.getStreetAddress3())
            .withAddressLocality(address.getAddressLocality())
            .withAddressRegion(address.getAddressRegion())
            .withAddressCountry(address.getAddressCountry())
            .withPostalCode(address.getPostalCode())
            .withPostOfficeBoxNumber(address.getPostOfficeBoxNumber());
    }
}
