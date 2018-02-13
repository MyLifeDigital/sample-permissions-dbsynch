package io.consentric.connector.client.permissionsService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
    private String citizenId;
    private String externalRef;
    private List<ChangeDTO> changes;

    @JsonCreator
    public TransactionDTO(@JsonProperty("citizenId") String citizenId,
                          @JsonProperty("externalRef") String externalRef,
                          @JsonProperty("changes") List<ChangeDTO> changes) {
        this.citizenId = citizenId;
        this.externalRef = externalRef;
        this.changes = changes;
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

    public List<ChangeDTO> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeDTO> changes) {
        this.changes = changes;
    }
}
