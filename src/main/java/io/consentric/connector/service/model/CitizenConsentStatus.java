package io.consentric.connector.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class CitizenConsentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String citizenId;
    private String externalRef;
    private String optionId;
    private String state;
    private Instant obtainedAt;
    private Instant validUntil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Instant getObtainedAt() {
        return obtainedAt;
    }

    public void setObtainedAt(Instant obtainedAt) {
        this.obtainedAt = obtainedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public CitizenConsentStatus withCitizenId(String citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public CitizenConsentStatus withExternalRef(String externalRef) {
        this.externalRef = externalRef;
        return this;
    }

    public CitizenConsentStatus withOptionId(String optionId) {
        this.optionId = optionId;
        return this;
    }

    public CitizenConsentStatus withState(String state) {
        this.state = state;
        return this;
    }

    public CitizenConsentStatus withObtainedAt(Instant obtainedAt) {
        this.obtainedAt = obtainedAt;
        return this;
    }

    public CitizenConsentStatus withValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
        return this;
    }
}
