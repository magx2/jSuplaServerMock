package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * IODeviceUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class IODeviceUpdateRequest {
    @JsonProperty("comment")
    private String comment = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    public IODeviceUpdateRequest comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Get comment
     *
     * @return comment
     **/
    @ApiModelProperty(value = "")

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public IODeviceUpdateRequest enabled(Boolean enabled) {
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

    public IODeviceUpdateRequest locationId(Integer locationId) {
        this.locationId = locationId;
        return this;
    }

    /**
     * Get locationId
     *
     * @return locationId
     **/
    @ApiModelProperty(value = "")

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IODeviceUpdateRequest ioDeviceUpdateRequest = (IODeviceUpdateRequest) o;
        return Objects.equals(this.comment, ioDeviceUpdateRequest.comment) &&
                       Objects.equals(this.enabled, ioDeviceUpdateRequest.enabled) &&
                       Objects.equals(this.locationId, ioDeviceUpdateRequest.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, enabled, locationId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IODeviceUpdateRequest {\n");

        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
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
