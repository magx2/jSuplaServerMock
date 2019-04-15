package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ChannelUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelUpdateRequest {
    @JsonProperty("functionId")
    private Integer functionId = null;

    @JsonProperty("param1")
    private Integer param1 = null;

    @JsonProperty("param2")
    private Integer param2 = null;

    @JsonProperty("param3")
    private Integer param3 = null;

    @JsonProperty("textParam1")
    private String textParam1 = null;

    @JsonProperty("textParam2")
    private String textParam2 = null;

    @JsonProperty("textParam3")
    private String textParam3 = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("altIcon")
    private Integer altIcon = null;

    @JsonProperty("hidden")
    private Boolean hidden = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    @JsonProperty("inheritedLocation")
    private Boolean inheritedLocation = null;

    @JsonProperty("userIconId")
    private Integer userIconId = null;

    public ChannelUpdateRequest functionId(Integer functionId) {
        this.functionId = functionId;
        return this;
    }

    /**
     * Get functionId
     *
     * @return functionId
     **/
    @ApiModelProperty(value = "")

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public ChannelUpdateRequest param1(Integer param1) {
        this.param1 = param1;
        return this;
    }

    /**
     * Get param1
     *
     * @return param1
     **/
    @ApiModelProperty(value = "")

    public Integer getParam1() {
        return param1;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public ChannelUpdateRequest param2(Integer param2) {
        this.param2 = param2;
        return this;
    }

    /**
     * Get param2
     *
     * @return param2
     **/
    @ApiModelProperty(value = "")

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

    public ChannelUpdateRequest param3(Integer param3) {
        this.param3 = param3;
        return this;
    }

    /**
     * Get param3
     *
     * @return param3
     **/
    @ApiModelProperty(value = "")

    public Integer getParam3() {
        return param3;
    }

    public void setParam3(Integer param3) {
        this.param3 = param3;
    }

    public ChannelUpdateRequest textParam1(String textParam1) {
        this.textParam1 = textParam1;
        return this;
    }

    /**
     * Get textParam1
     *
     * @return textParam1
     **/
    @ApiModelProperty(value = "")

    public String getTextParam1() {
        return textParam1;
    }

    public void setTextParam1(String textParam1) {
        this.textParam1 = textParam1;
    }

    public ChannelUpdateRequest textParam2(String textParam2) {
        this.textParam2 = textParam2;
        return this;
    }

    /**
     * Get textParam2
     *
     * @return textParam2
     **/
    @ApiModelProperty(value = "")

    public String getTextParam2() {
        return textParam2;
    }

    public void setTextParam2(String textParam2) {
        this.textParam2 = textParam2;
    }

    public ChannelUpdateRequest textParam3(String textParam3) {
        this.textParam3 = textParam3;
        return this;
    }

    /**
     * Get textParam3
     *
     * @return textParam3
     **/
    @ApiModelProperty(value = "")

    public String getTextParam3() {
        return textParam3;
    }

    public void setTextParam3(String textParam3) {
        this.textParam3 = textParam3;
    }

    public ChannelUpdateRequest caption(String caption) {
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

    public ChannelUpdateRequest altIcon(Integer altIcon) {
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

    public ChannelUpdateRequest hidden(Boolean hidden) {
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

    public ChannelUpdateRequest locationId(Integer locationId) {
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

    public ChannelUpdateRequest inheritedLocation(Boolean inheritedLocation) {
        this.inheritedLocation = inheritedLocation;
        return this;
    }

    /**
     * Get inheritedLocation
     *
     * @return inheritedLocation
     **/
    @ApiModelProperty(value = "")

    public Boolean isInheritedLocation() {
        return inheritedLocation;
    }

    public void setInheritedLocation(Boolean inheritedLocation) {
        this.inheritedLocation = inheritedLocation;
    }

    public ChannelUpdateRequest userIconId(Integer userIconId) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelUpdateRequest channelUpdateRequest = (ChannelUpdateRequest) o;
        return Objects.equals(this.functionId, channelUpdateRequest.functionId) &&
                       Objects.equals(this.param1, channelUpdateRequest.param1) &&
                       Objects.equals(this.param2, channelUpdateRequest.param2) &&
                       Objects.equals(this.param3, channelUpdateRequest.param3) &&
                       Objects.equals(this.textParam1, channelUpdateRequest.textParam1) &&
                       Objects.equals(this.textParam2, channelUpdateRequest.textParam2) &&
                       Objects.equals(this.textParam3, channelUpdateRequest.textParam3) &&
                       Objects.equals(this.caption, channelUpdateRequest.caption) &&
                       Objects.equals(this.altIcon, channelUpdateRequest.altIcon) &&
                       Objects.equals(this.hidden, channelUpdateRequest.hidden) &&
                       Objects.equals(this.locationId, channelUpdateRequest.locationId) &&
                       Objects.equals(this.inheritedLocation, channelUpdateRequest.inheritedLocation) &&
                       Objects.equals(this.userIconId, channelUpdateRequest.userIconId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionId, param1, param2, param3, textParam1, textParam2, textParam3, caption, altIcon, hidden, locationId, inheritedLocation, userIconId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelUpdateRequest {\n");

        sb.append("    functionId: ").append(toIndentedString(functionId)).append("\n");
        sb.append("    param1: ").append(toIndentedString(param1)).append("\n");
        sb.append("    param2: ").append(toIndentedString(param2)).append("\n");
        sb.append("    param3: ").append(toIndentedString(param3)).append("\n");
        sb.append("    textParam1: ").append(toIndentedString(textParam1)).append("\n");
        sb.append("    textParam2: ").append(toIndentedString(textParam2)).append("\n");
        sb.append("    textParam3: ").append(toIndentedString(textParam3)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    altIcon: ").append(toIndentedString(altIcon)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    inheritedLocation: ").append(toIndentedString(inheritedLocation)).append("\n");
        sb.append("    userIconId: ").append(toIndentedString(userIconId)).append("\n");
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
