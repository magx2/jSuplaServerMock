package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccessIdentifier
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class AccessIdentifier {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("locationsIds")
    @Valid
    private List<Integer> locationsIds = null;

    @JsonProperty("clientAppsIds")
    @Valid
    private List<Integer> clientAppsIds = null;

    @JsonProperty("locations")
    @Valid
    private List<Location> locations = null;

    @JsonProperty("clientApps")
    @Valid
    private List<ClientApp> clientApps = null;

    public AccessIdentifier id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Access Identifier identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Access Identifier identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccessIdentifier caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Location caption
     *
     * @return caption
     **/
    @ApiModelProperty(value = "Location caption")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public AccessIdentifier enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * `true` if the location is enabled, `false` otherwise
     *
     * @return enabled
     **/
    @ApiModelProperty(value = "`true` if the location is enabled, `false` otherwise")

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public AccessIdentifier locationsIds(List<Integer> locationsIds) {
        this.locationsIds = locationsIds;
        return this;
    }

    public AccessIdentifier addLocationsIdsItem(Integer locationsIdsItem) {
        if (this.locationsIds == null) {
            this.locationsIds = new ArrayList<Integer>();
        }
        this.locationsIds.add(locationsIdsItem);
        return this;
    }

    /**
     * array containing the location idenfifiers assigned to this access ID
     *
     * @return locationsIds
     **/
    @ApiModelProperty(value = "array containing the location idenfifiers assigned to this access ID")

    public List<Integer> getLocationsIds() {
        return locationsIds;
    }

    public void setLocationsIds(List<Integer> locationsIds) {
        this.locationsIds = locationsIds;
    }

    public AccessIdentifier clientAppsIds(List<Integer> clientAppsIds) {
        this.clientAppsIds = clientAppsIds;
        return this;
    }

    public AccessIdentifier addClientAppsIdsItem(Integer clientAppsIdsItem) {
        if (this.clientAppsIds == null) {
            this.clientAppsIds = new ArrayList<Integer>();
        }
        this.clientAppsIds.add(clientAppsIdsItem);
        return this;
    }

    /**
     * array containing the client apps idenfifiers assigned to this access ID
     *
     * @return clientAppsIds
     **/
    @ApiModelProperty(value = "array containing the client apps idenfifiers assigned to this access ID")

    public List<Integer> getClientAppsIds() {
        return clientAppsIds;
    }

    public void setClientAppsIds(List<Integer> clientAppsIds) {
        this.clientAppsIds = clientAppsIds;
    }

    public AccessIdentifier locations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

    public AccessIdentifier addLocationsItem(Location locationsItem) {
        if (this.locations == null) {
            this.locations = new ArrayList<Location>();
        }
        this.locations.add(locationsItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter.
     *
     * @return locations
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter.")
    @Valid
    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public AccessIdentifier clientApps(List<ClientApp> clientApps) {
        this.clientApps = clientApps;
        return this;
    }

    public AccessIdentifier addClientAppsItem(ClientApp clientAppsItem) {
        if (this.clientApps == null) {
            this.clientApps = new ArrayList<ClientApp>();
        }
        this.clientApps.add(clientAppsItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter.
     *
     * @return clientApps
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter.")
    @Valid
    public List<ClientApp> getClientApps() {
        return clientApps;
    }

    public void setClientApps(List<ClientApp> clientApps) {
        this.clientApps = clientApps;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccessIdentifier accessIdentifier = (AccessIdentifier) o;
        return Objects.equals(this.id, accessIdentifier.id) &&
                       Objects.equals(this.caption, accessIdentifier.caption) &&
                       Objects.equals(this.enabled, accessIdentifier.enabled) &&
                       Objects.equals(this.locationsIds, accessIdentifier.locationsIds) &&
                       Objects.equals(this.clientAppsIds, accessIdentifier.clientAppsIds) &&
                       Objects.equals(this.locations, accessIdentifier.locations) &&
                       Objects.equals(this.clientApps, accessIdentifier.clientApps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caption, enabled, locationsIds, clientAppsIds, locations, clientApps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccessIdentifier {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    locationsIds: ").append(toIndentedString(locationsIds)).append("\n");
        sb.append("    clientAppsIds: ").append(toIndentedString(clientAppsIds)).append("\n");
        sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
        sb.append("    clientApps: ").append(toIndentedString(clientApps)).append("\n");
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
