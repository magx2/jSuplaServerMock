package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccessIdentifierUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class AccessIdentifierUpdateRequest {
    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("locationsIds")
    @Valid
    private List<Integer> locationsIds = null;

    @JsonProperty("clientAppsIds")
    @Valid
    private List<Integer> clientAppsIds = null;

    public AccessIdentifierUpdateRequest enabled(Boolean enabled) {
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

    public AccessIdentifierUpdateRequest caption(String caption) {
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

    public AccessIdentifierUpdateRequest password(String password) {
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

    public AccessIdentifierUpdateRequest locationsIds(List<Integer> locationsIds) {
        this.locationsIds = locationsIds;
        return this;
    }

    public AccessIdentifierUpdateRequest addLocationsIdsItem(Integer locationsIdsItem) {
        if (this.locationsIds == null) {
            this.locationsIds = new ArrayList<Integer>();
        }
        this.locationsIds.add(locationsIdsItem);
        return this;
    }

    /**
     * Locations identifiers to assign to this Access Identifier.
     *
     * @return locationsIds
     **/
    @ApiModelProperty(value = "Locations identifiers to assign to this Access Identifier.")

    public List<Integer> getLocationsIds() {
        return locationsIds;
    }

    public void setLocationsIds(List<Integer> locationsIds) {
        this.locationsIds = locationsIds;
    }

    public AccessIdentifierUpdateRequest clientAppsIds(List<Integer> clientAppsIds) {
        this.clientAppsIds = clientAppsIds;
        return this;
    }

    public AccessIdentifierUpdateRequest addClientAppsIdsItem(Integer clientAppsIdsItem) {
        if (this.clientAppsIds == null) {
            this.clientAppsIds = new ArrayList<Integer>();
        }
        this.clientAppsIds.add(clientAppsIdsItem);
        return this;
    }

    /**
     * Client Apps identifiers to assign to this Access Identifier. If client app is connected to any other Client ID, it will be disconnected from the old one before assigning.
     *
     * @return clientAppsIds
     **/
    @ApiModelProperty(value = "Client Apps identifiers to assign to this Access Identifier. If client app is connected to any other Client ID, it will be disconnected from the old one before assigning.")

    public List<Integer> getClientAppsIds() {
        return clientAppsIds;
    }

    public void setClientAppsIds(List<Integer> clientAppsIds) {
        this.clientAppsIds = clientAppsIds;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccessIdentifierUpdateRequest accessIdentifierUpdateRequest = (AccessIdentifierUpdateRequest) o;
        return Objects.equals(this.enabled, accessIdentifierUpdateRequest.enabled) &&
                       Objects.equals(this.caption, accessIdentifierUpdateRequest.caption) &&
                       Objects.equals(this.password, accessIdentifierUpdateRequest.password) &&
                       Objects.equals(this.locationsIds, accessIdentifierUpdateRequest.locationsIds) &&
                       Objects.equals(this.clientAppsIds, accessIdentifierUpdateRequest.clientAppsIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, caption, password, locationsIds, clientAppsIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccessIdentifierUpdateRequest {\n");

        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    locationsIds: ").append(toIndentedString(locationsIds)).append("\n");
        sb.append("    clientAppsIds: ").append(toIndentedString(clientAppsIds)).append("\n");
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
