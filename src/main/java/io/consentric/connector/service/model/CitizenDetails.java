package io.consentric.connector.service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CitizenDetails {
    @Id
    private String citizenId;
    private String externalRef;
    private String organisationName;
    private String email;
    private String telephone;
    private String givenName;
    private String additionalName;
    private String familyName;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String addressLocality;
    private String addressRegion;
    private String addressCountry;
    private String postalCode;
    private String postOfficeBoxNumber;

    public CitizenDetails() {

    }

    public CitizenDetails withCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public CitizenDetails withExternalRef(String externalRef) {
        this.externalRef = externalRef;
        return this;
    }

    public CitizenDetails withOrganisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }

    public CitizenDetails withEmail(String email) {
        this.email = email;
        return this;
    }

    public CitizenDetails withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public CitizenDetails withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public CitizenDetails withAdditionalName(String additionalName) {
        this.additionalName = additionalName;
        return this;
    }

    public CitizenDetails withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public CitizenDetails withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public CitizenDetails withStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
        return this;
    }

    public CitizenDetails withStreetAddress3(String streetAddress3) {
        this.streetAddress3 = streetAddress3;
        return this;
    }

    public CitizenDetails withAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
        return this;
    }

    public CitizenDetails withAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
        return this;
    }

    public CitizenDetails withAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
        return this;
    }

    public CitizenDetails withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public CitizenDetails withPostOfficeBoxNumber(String postOfficeBoxNumber) {
        this.postOfficeBoxNumber = postOfficeBoxNumber;
        return this;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public void setStreetAddress3(String streetAddress3) {
        this.streetAddress3 = streetAddress3;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostOfficeBoxNumber() {
        return postOfficeBoxNumber;
    }

    public void setPostOfficeBoxNumber(String postOfficeBoxNumber) {
        this.postOfficeBoxNumber = postOfficeBoxNumber;
    }
}
