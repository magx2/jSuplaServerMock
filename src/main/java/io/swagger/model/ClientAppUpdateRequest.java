package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ClientAppUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ClientAppUpdateRequest {
    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("accessIdId")
    private Integer accessIdId = null;

    public ClientAppUpdateRequest caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Get caption
     *
     * @return caption
     **/
    @ApiModelProperty(value = "")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ClientAppUpdateRequest enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    @ApiModelProperty(value = "")

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public ClientAppUpdateRequest accessIdId(Integer accessIdId) {
        this.accessIdId = accessIdId;
        return this;
    }

    /**
     * Get accessIdId
     *
     * @return accessIdId
     **/
    @ApiModelProperty(value = "")

    public Integer getAccessIdId() {
        return accessIdId;
    }

    public void setAccessIdId(Integer accessIdId) {
        this.accessIdId = accessIdId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClientAppUpdateRequest clientAppUpdateRequest = (ClientAppUpdateRequest) o;
        return Objects.equals(this.caption, clientAppUpdateRequest.caption) &&
                       Objects.equals(this.enabled, clientAppUpdateRequest.enabled) &&
                       Objects.equals(this.accessIdId, clientAppUpdateRequest.accessIdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, enabled, accessIdId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClientAppUpdateRequest {\n");

        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    accessIdId: ").append(toIndentedString(accessIdId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
