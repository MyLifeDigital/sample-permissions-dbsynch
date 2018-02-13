package io.consentric.connector.client.permissionsService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurationDTO {
    private List<DataDTO> data;
    private List<PurposeDTO> purposes;
    private List<PartyDTO> parties;
    private List<OptionDTO> options;

    @JsonCreator
    public ConfigurationDTO(@JsonProperty("data") List<DataDTO> data,
                            @JsonProperty("purposes")List<PurposeDTO> purposes,
                            @JsonProperty("parties") List<PartyDTO> parties,
                            @JsonProperty("options") List<OptionDTO> options) {
        this.data = data;
        this.purposes = purposes;
        this.parties = parties;
        this.options = options;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public List<PurposeDTO> getPurposes() {
        return purposes;
    }

    public void setPurposes(List<PurposeDTO> purposes) {
        this.purposes = purposes;
    }

    public List<PartyDTO> getParties() {
        return parties;
    }

    public void setParties(List<PartyDTO> parties) {
        this.parties = parties;
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
}
