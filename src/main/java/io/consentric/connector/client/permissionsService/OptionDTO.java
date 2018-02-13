package io.consentric.connector.client.permissionsService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionDTO {
    @Id
    private String id;
    private String dataId;
    private String purposeId;
    private String partyId;

    public OptionDTO() {

    }

    @JsonCreator
    public OptionDTO(@JsonProperty("id") String id,
                     @JsonProperty("dataId") String dataId,
                     @JsonProperty("purposeId") String purposeId,
                     @JsonProperty("partyId") String partyId) {
        this.id = id;
        this.dataId = dataId;
        this.purposeId = purposeId;
        this.partyId = partyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(String purposeId) {
        this.purposeId = purposeId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}
