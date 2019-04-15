package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ChannelGroup
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelGroup {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("hidden")
    private Boolean hidden = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("function")
    private ChannelFunction function = null;

    @JsonProperty("functionId")
    private Integer functionId = null;

    @JsonProperty("userIconId")
    private Integer userIconId = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    @JsonProperty("location")
    private Location location = null;

    @JsonProperty("channelIds")
    @Valid
    private List<Integer> channelIds = null;

    @JsonProperty("channels")
    @Valid
    private List<Channel> channels = null;

    @JsonProperty("altIcon")
    private Integer altIcon = null;

    public ChannelGroup id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Channel group identifier
     *
     * @return id
     **/
    @ApiModelProperty(example = "1", value = "Channel group identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChannelGroup hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Whether this channel group is shown on client apps or not
     *
     * @return hidden
     **/
    @ApiModelProperty(value = "Whether this channel group is shown on client apps or not")

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public ChannelGroup caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Channel caption
     *
     * @return caption
     **/
    @ApiModelProperty(value = "Channel caption")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ChannelGroup function(ChannelFunction function) {
        this.function = function;
        return this;
    }

    /**
     * Get function
     *
     * @return function
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ChannelFunction getFunction() {
        return function;
    }

    public void setFunction(ChannelFunction function) {
        this.function = function;
    }

    public ChannelGroup functionId(Integer functionId) {
        this.functionId = functionId;
        return this;
    }

    /**
     * Get functionId
     *
     * @return functionId
     **/
    @ApiModelProperty(example = "60", value = "")

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public ChannelGroup userIconId(Integer userIconId) {
        this.userIconId = userIconId;
        return this;
    }

    /**
     * Get userIconId
     *
     * @return userIconId
     **/
    @ApiModelProperty(value = "")

    public Integer getUserIconId() {
        return userIconId;
    }

    public void setUserIconId(Integer userIconId) {
        this.userIconId = userIconId;
    }

    public ChannelGroup locationId(Integer locationId) {
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

    public ChannelGroup location(Location location) {
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

    public ChannelGroup channelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
        return this;
    }

    public ChannelGroup addChannelIdsItem(Integer channelIdsItem) {
        if (this.channelIds == null) {
            this.channelIds = new ArrayList<Integer>();
        }
        this.channelIds.add(channelIdsItem);
        return this;
    }

    /**
     * Get channelIds
     *
     * @return channelIds
     **/
    @ApiModelProperty(value = "")

    public List<Integer> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
    }

    public ChannelGroup channels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }

    public ChannelGroup addChannelsItem(Channel channelsItem) {
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

    public ChannelGroup altIcon(Integer altIcon) {
        this.altIcon = altIcon;
        return this;
    }

    /**
     * Chosen alternative icon idenifier. Should not be greater than `funciton.maxAlternativeIconIndex`
     *
     * @return altIcon
     **/
    @ApiModelProperty(value = "Chosen alternative icon idenifier. Should not be greater than `funciton.maxAlternativeIconIndex`")

    public Integer getAltIcon() {
        return altIcon;
    }

    public void setAltIcon(Integer altIcon) {
        this.altIcon = altIcon;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelGroup channelGroup = (ChannelGroup) o;
        return Objects.equals(this.id, channelGroup.id) &&
                       Objects.equals(this.hidden, channelGroup.hidden) &&
                       Objects.equals(this.caption, channelGroup.caption) &&
                       Objects.equals(this.function, channelGroup.function) &&
                       Objects.equals(this.functionId, channelGroup.functionId) &&
                       Objects.equals(this.userIconId, channelGroup.userIconId) &&
                       Objects.equals(this.locationId, channelGroup.locationId) &&
                       Objects.equals(this.location, channelGroup.location) &&
                       Objects.equals(this.channelIds, channelGroup.channelIds) &&
                       Objects.equals(this.channels, channelGroup.channels) &&
                       Objects.equals(this.altIcon, channelGroup.altIcon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hidden, caption, function, functionId, userIconId, locationId, location, channelIds, channels, altIcon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelGroup {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    function: ").append(toIndentedString(function)).append("\n");
        sb.append("    functionId: ").append(toIndentedString(functionId)).append("\n");
        sb.append("    userIconId: ").append(toIndentedString(userIconId)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    channelIds: ").append(toIndentedString(channelIds)).append("\n");
        sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
        sb.append("    altIcon: ").append(toIndentedString(altIcon)).append("\n");
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
