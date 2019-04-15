package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Device
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class Device {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("comment")
    private String comment = null;

    @JsonProperty("regDate")
    private OffsetDateTime regDate = null;

    @JsonProperty("regIpv4")
    private Long regIpv4 = null;

    @JsonProperty("lastConnected")
    private OffsetDateTime lastConnected = null;

    @JsonProperty("lastIpv4")
    private Long lastIpv4 = null;

    @JsonProperty("softwareVersion")
    private String softwareVersion = null;

    @JsonProperty("gUIDString")
    private String gUIDString = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    @JsonProperty("originalLocationId")
    private Integer originalLocationId = null;

    @JsonProperty("channelsIds")
    @Valid
    private List<Integer> channelsIds = null;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("location")
    private Location location = null;

    @JsonProperty("originalLocation")
    private Location originalLocation = null;

    @JsonProperty("channels")
    @Valid
    private List<Channel> channels = null;

    @JsonProperty("schedules")
    @Valid
    private List<Schedule> schedules = null;

    public Device id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Device identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Device identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Device name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device enabled(Boolean enabled) {
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

    public Device comment(String comment) {
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

    public Device regDate(OffsetDateTime regDate) {
        this.regDate = regDate;
        return this;
    }

    /**
     * Get regDate
     *
     * @return regDate
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(OffsetDateTime regDate) {
        this.regDate = regDate;
    }

    public Device regIpv4(Long regIpv4) {
        this.regIpv4 = regIpv4;
        return this;
    }

    /**
     * Get regIpv4
     *
     * @return regIpv4
     **/
    @ApiModelProperty(value = "")

    public Long getRegIpv4() {
        return regIpv4;
    }

    public void setRegIpv4(Long regIpv4) {
        this.regIpv4 = regIpv4;
    }

    public Device lastConnected(OffsetDateTime lastConnected) {
        this.lastConnected = lastConnected;
        return this;
    }

    /**
     * Get lastConnected
     *
     * @return lastConnected
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(OffsetDateTime lastConnected) {
        this.lastConnected = lastConnected;
    }

    public Device lastIpv4(Long lastIpv4) {
        this.lastIpv4 = lastIpv4;
        return this;
    }

    /**
     * Get lastIpv4
     *
     * @return lastIpv4
     **/
    @ApiModelProperty(value = "")

    public Long getLastIpv4() {
        return lastIpv4;
    }

    public void setLastIpv4(Long lastIpv4) {
        this.lastIpv4 = lastIpv4;
    }

    public Device softwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    /**
     * Get softwareVersion
     *
     * @return softwareVersion
     **/
    @ApiModelProperty(value = "")

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public Device gUIDString(String gUIDString) {
        this.gUIDString = gUIDString;
        return this;
    }

    /**
     * Get gUIDString
     *
     * @return gUIDString
     **/
    @ApiModelProperty(value = "")

    public String getGUIDString() {
        return gUIDString;
    }

    public void setGUIDString(String gUIDString) {
        this.gUIDString = gUIDString;
    }

    public Device locationId(Integer locationId) {
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

    public Device originalLocationId(Integer originalLocationId) {
        this.originalLocationId = originalLocationId;
        return this;
    }

    /**
     * Get originalLocationId
     *
     * @return originalLocationId
     **/
    @ApiModelProperty(value = "")

    public Integer getOriginalLocationId() {
        return originalLocationId;
    }

    public void setOriginalLocationId(Integer originalLocationId) {
        this.originalLocationId = originalLocationId;
    }

    public Device channelsIds(List<Integer> channelsIds) {
        this.channelsIds = channelsIds;
        return this;
    }

    public Device addChannelsIdsItem(Integer channelsIdsItem) {
        if (this.channelsIds == null) {
            this.channelsIds = new ArrayList<Integer>();
        }
        this.channelsIds.add(channelsIdsItem);
        return this;
    }

    /**
     * Get channelsIds
     *
     * @return channelsIds
     **/
    @ApiModelProperty(value = "")

    public List<Integer> getChannelsIds() {
        return channelsIds;
    }

    public void setChannelsIds(List<Integer> channelsIds) {
        this.channelsIds = channelsIds;
    }

    public Device connected(Boolean connected) {
        this.connected = connected;
        return this;
    }

    /**
     * Get connected
     *
     * @return connected
     **/
    @ApiModelProperty(value = "")

    public Boolean isConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Device location(Location location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Device originalLocation(Location originalLocation) {
        this.originalLocation = originalLocation;
        return this;
    }

    /**
     * Get originalLocation
     *
     * @return originalLocation
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Location getOriginalLocation() {
        return originalLocation;
    }

    public void setOriginalLocation(Location originalLocation) {
        this.originalLocation = originalLocation;
    }

    public Device channels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }

    public Device addChannelsItem(Channel channelsItem) {
        if (this.channels == null) {
            this.channels = new ArrayList<Channel>();
        }
        this.channels.add(channelsItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter.
     *
     * @return channels
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter.")
    @Valid
    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public Device schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public Device addSchedulesItem(Schedule schedulesItem) {
        if (this.schedules == null) {
            this.schedules = new ArrayList<Schedule>();
        }
        this.schedules.add(schedulesItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter.
     *
     * @return schedules
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter.")
    @Valid
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(this.id, device.id) &&
                       Objects.equals(this.name, device.name) &&
                       Objects.equals(this.enabled, device.enabled) &&
                       Objects.equals(this.comment, device.comment) &&
                       Objects.equals(this.regDate, device.regDate) &&
                       Objects.equals(this.regIpv4, device.regIpv4) &&
                       Objects.equals(this.lastConnected, device.lastConnected) &&
                       Objects.equals(this.lastIpv4, device.lastIpv4) &&
                       Objects.equals(this.softwareVersion, device.softwareVersion) &&
                       Objects.equals(this.gUIDString, device.gUIDString) &&
                       Objects.equals(this.locationId, device.locationId) &&
                       Objects.equals(this.originalLocationId, device.originalLocationId) &&
                       Objects.equals(this.channelsIds, device.channelsIds) &&
                       Objects.equals(this.connected, device.connected) &&
                       Objects.equals(this.location, device.location) &&
                       Objects.equals(this.originalLocation, device.originalLocation) &&
                       Objects.equals(this.channels, device.channels) &&
                       Objects.equals(this.schedules, device.schedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, enabled, comment, regDate, regIpv4, lastConnected, lastIpv4, softwareVersion, gUIDString, locationId, originalLocationId, channelsIds, connected, location, originalLocation, channels, schedules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Device {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("    regDate: ").append(toIndentedString(regDate)).append("\n");
        sb.append("    regIpv4: ").append(toIndentedString(regIpv4)).append("\n");
        sb.append("    lastConnected: ").append(toIndentedString(lastConnected)).append("\n");
        sb.append("    lastIpv4: ").append(toIndentedString(lastIpv4)).append("\n");
        sb.append("    softwareVersion: ").append(toIndentedString(softwareVersion)).append("\n");
        sb.append("    gUIDString: ").append(toIndentedString(gUIDString)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    originalLocationId: ").append(toIndentedString(originalLocationId)).append("\n");
        sb.append("    channelsIds: ").append(toIndentedString(channelsIds)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    originalLocation: ").append(toIndentedString(originalLocation)).append("\n");
        sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
        sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
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
