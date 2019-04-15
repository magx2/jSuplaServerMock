package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LocationUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class LocationUpdateRequest {
    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("accessIdsIds")
    @Valid
    private List<Integer> accessIdsIds = null;

    public LocationUpdateRequest enabled(Boolean enabled) {
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

    public LocationUpdateRequest caption(String caption) {
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

    public LocationUpdateRequest password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Provide new password if you want to change it.
     *
     * @return password
     **/
    @ApiModelProperty(value = "Provide new password if you want to change it.")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocationUpdateRequest accessIdsIds(List<Integer> accessIdsIds) {
        this.accessIdsIds = accessIdsIds;
        return this;
    }

    public LocationUpdateRequest addAccessIdsIdsItem(Integer accessIdsIdsItem) {
        if (this.accessIdsIds == null) {
            this.accessIdsIds = new ArrayList<Integer>();
        }
        this.accessIdsIds.add(accessIdsIdsItem);
        return this;
    }

    /**
     * Access Identifiers identifiers to assign to this location.
     *
     * @return accessIdsIds
     **/
    @ApiModelProperty(value = "Access Identifiers identifiers to assign to this location.")

    public List<Integer> getAccessIdsIds() {
        return accessIdsIds;
    }

    public void setAccessIdsIds(List<Integer> accessIdsIds) {
        this.accessIdsIds = accessIdsIds;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationUpdateRequest locationUpdateRequest = (LocationUpdateRequest) o;
        return Objects.equals(this.enabled, locationUpdateRequest.enabled) &&
                       Objects.equals(this.caption, locationUpdateRequest.caption) &&
                       Objects.equals(this.password, locationUpdateRequest.password) &&
                       Objects.equals(this.accessIdsIds, locationUpdateRequest.accessIdsIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, caption, password, accessIdsIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LocationUpdateRequest {\n");

        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    accessIdsIds: ").append(toIndentedString(accessIdsIds)).append("\n");
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
