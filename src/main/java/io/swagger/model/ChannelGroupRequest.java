package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ChannelGroupRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelGroupRequest {
    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("altIcon")
    private Integer altIcon = null;

    @JsonProperty("userIconId")
    private Integer userIconId = null;

    @JsonProperty("hidden")
    private Boolean hidden = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    @JsonProperty("channelIds")
    @Valid
    private List<Integer> channelIds = new ArrayList<Integer>();

    public ChannelGroupRequest caption(String caption) {
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

    public ChannelGroupRequest altIcon(Integer altIcon) {
        this.altIcon = altIcon;
        return this;
    }

    /**
     * Get altIcon
     *
     * @return altIcon
     **/
    @ApiModelProperty(value = "")

    public Integer getAltIcon() {
        return altIcon;
    }

    public void setAltIcon(Integer altIcon) {
        this.altIcon = altIcon;
    }

    public ChannelGroupRequest userIconId(Integer userIconId) {
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

    public ChannelGroupRequest hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Get hidden
     *
     * @return hidden
     **/
    @ApiModelProperty(value = "")

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public ChannelGroupRequest locationId(Integer locationId) {
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

    public ChannelGroupRequest channelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
        return this;
    }

    public ChannelGroupRequest addChannelIdsItem(Integer channelIdsItem) {
        this.channelIds.add(channelIdsItem);
        return this;
    }

    /**
     * Get channelIds
     *
     * @return channelIds
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public List<Integer> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelGroupRequest channelGroupRequest = (ChannelGroupRequest) o;
        return Objects.equals(this.caption, channelGroupRequest.caption) &&
                       Objects.equals(this.altIcon, channelGroupRequest.altIcon) &&
                       Objects.equals(this.userIconId, channelGroupRequest.userIconId) &&
                       Objects.equals(this.hidden, channelGroupRequest.hidden) &&
                       Objects.equals(this.locationId, channelGroupRequest.locationId) &&
                       Objects.equals(this.channelIds, channelGroupRequest.channelIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, altIcon, userIconId, hidden, locationId, channelIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelGroupRequest {\n");

        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    altIcon: ").append(toIndentedString(altIcon)).append("\n");
        sb.append("    userIconId: ").append(toIndentedString(userIconId)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    channelIds: ").append(toIndentedString(channelIds)).append("\n");
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
