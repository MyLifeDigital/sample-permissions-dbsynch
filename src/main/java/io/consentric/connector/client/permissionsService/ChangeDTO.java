package io.consentric.connector.client.permissionsService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeDTO {
    private String optionId;
    private String justification;
    private String state;
    private Instant obtainedAt;
    private Instant validUntil;

    @JsonCreator
    public ChangeDTO(@JsonProperty("optionId") String optionId,
                     @JsonProperty("justification") String justification,
                     @JsonProperty("state") String state,
                     @JsonProperty("obtainedAt") Instant obtainedAt,
                     @JsonProperty("validUntil") Instant validUntil) {
        this.optionId = optionId;
        this.justification = justification;
        this.state = state;
        this.obtainedAt = obtainedAt;
        this.validUntil = validUntil;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
}
