package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Channel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class Channel {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("channelNumber")
    private Integer channelNumber = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("type")
    private ChannelType type = null;

    @JsonProperty("function")
    private ChannelFunction function = null;

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

    @JsonProperty("altIcon")
    private Integer altIcon = null;

    @JsonProperty("hidden")
    private Boolean hidden = null;

    @JsonProperty("inheritedLocation")
    private Boolean inheritedLocation = null;

    @JsonProperty("iodeviceId")
    private Integer iodeviceId = null;

    @JsonProperty("locationId")
    private Integer locationId = null;

    @JsonProperty("functionId")
    private Integer functionId = null;

    @JsonProperty("typeId")
    private Integer typeId = null;

    @JsonProperty("userIconId")
    private Integer userIconId = null;

    @JsonProperty("iodevice")
    private Device iodevice = null;

    @JsonProperty("location")
    private Location location = null;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("state")
    private ChannelState state = null;

    @JsonProperty("supportedFunctions")
    @Valid
    private List<ChannelFunction> supportedFunctions = null;

    public Channel id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Channel identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Channel identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Channel channelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
        return this;
    }

    /**
     * Channel ordinal number in its IO Device
     *
     * @return channelNumber
     **/
    @ApiModelProperty(value = "Channel ordinal number in its IO Device")

    public Integer getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    public Channel caption(String caption) {
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

    public Channel type(ChannelType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ChannelType getType() {
        return type;
    }

    public void setType(ChannelType type) {
        this.type = type;
    }

    public Channel function(ChannelFunction function) {
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

    public Channel param1(Integer param1) {
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

    public Channel param2(Integer param2) {
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

    public Channel param3(Integer param3) {
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

    public Channel textParam1(String textParam1) {
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

    public Channel textParam2(String textParam2) {
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

    public Channel textParam3(String textParam3) {
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

    public Channel altIcon(Integer altIcon) {
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

    public Channel hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Whether this channel is shown on client apps or not
     *
     * @return hidden
     **/
    @ApiModelProperty(value = "Whether this channel is shown on client apps or not")

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Channel inheritedLocation(Boolean inheritedLocation) {
        this.inheritedLocation = inheritedLocation;
        return this;
    }

    /**
     * Whether this channel inherits its IO Device's location (`true`) or not (`false`)
     *
     * @return inheritedLocation
     **/
    @ApiModelProperty(value = "Whether this channel inherits its IO Device's location (`true`) or not (`false`)")

    public Boolean isInheritedLocation() {
        return inheritedLocation;
    }

    public void setInheritedLocation(Boolean inheritedLocation) {
        this.inheritedLocation = inheritedLocation;
    }

    public Channel iodeviceId(Integer iodeviceId) {
        this.iodeviceId = iodeviceId;
        return this;
    }

    /**
     * Get iodeviceId
     *
     * @return iodeviceId
     **/
    @ApiModelProperty(value = "")

    public Integer getIodeviceId() {
        return iodeviceId;
    }

    public void setIodeviceId(Integer iodeviceId) {
        this.iodeviceId = iodeviceId;
    }

    public Channel locationId(Integer locationId) {
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

    public Channel functionId(Integer functionId) {
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

    public Channel typeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    /**
     * Get typeId
     *
     * @return typeId
     **/
    @ApiModelProperty(example = "1000", value = "")

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Channel userIconId(Integer userIconId) {
        this.userIconId = userIconId;
        return this;
    }

    /**
     * Get userIconId
     *
     * @return userIconId
     **/
    @ApiModelProperty(example = "100", value = "")

    public Integer getUserIconId() {
        return userIconId;
    }

    public void setUserIconId(Integer userIconId) {
        this.userIconId = userIconId;
    }

    public Channel iodevice(Device iodevice) {
        this.iodevice = iodevice;
        return this;
    }

    /**
     * Get iodevice
     *
     * @return iodevice
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Device getIodevice() {
        return iodevice;
    }

    public void setIodevice(Device iodevice) {
        this.iodevice = iodevice;
    }

    public Channel location(Location location) {
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

    public Channel connected(Boolean connected) {
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

    public Channel state(ChannelState state) {
        this.state = state;
        return this;
    }

    /**
     * The channel's state. The value and the format is dependend on the channel's function. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-states).
     *
     * @return state
     **/
    @ApiModelProperty(example = "{}", value = "The channel's state. The value and the format is dependend on the channel's function. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-states).")

    public ChannelState getState() {
        return state;
    }

    public void setState(ChannelState state) {
        this.state = state;
    }

    public Channel supportedFunctions(List<ChannelFunction> supportedFunctions) {
        this.supportedFunctions = supportedFunctions;
        return this;
    }

    public Channel addSupportedFunctionsItem(ChannelFunction supportedFunctionsItem) {
        if (this.supportedFunctions == null) {
            this.supportedFunctions = new ArrayList<ChannelFunction>();
        }
        this.supportedFunctions.add(supportedFunctionsItem);
        return this;
    }

    /**
     * Get supportedFunctions
     *
     * @return supportedFunctions
     **/
    @ApiModelProperty(value = "")
    @Valid
    public List<ChannelFunction> getSupportedFunctions() {
        return supportedFunctions;
    }

    public void setSupportedFunctions(List<ChannelFunction> supportedFunctions) {
        this.supportedFunctions = supportedFunctions;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Channel channel = (Channel) o;
        return Objects.equals(this.id, channel.id) &&
                       Objects.equals(this.channelNumber, channel.channelNumber) &&
                       Objects.equals(this.caption, channel.caption) &&
                       Objects.equals(this.type, channel.type) &&
                       Objects.equals(this.function, channel.function) &&
                       Objects.equals(this.param1, channel.param1) &&
                       Objects.equals(this.param2, channel.param2) &&
                       Objects.equals(this.param3, channel.param3) &&
                       Objects.equals(this.textParam1, channel.textParam1) &&
                       Objects.equals(this.textParam2, channel.textParam2) &&
                       Objects.equals(this.textParam3, channel.textParam3) &&
                       Objects.equals(this.altIcon, channel.altIcon) &&
                       Objects.equals(this.hidden, channel.hidden) &&
                       Objects.equals(this.inheritedLocation, channel.inheritedLocation) &&
                       Objects.equals(this.iodeviceId, channel.iodeviceId) &&
                       Objects.equals(this.locationId, channel.locationId) &&
                       Objects.equals(this.functionId, channel.functionId) &&
                       Objects.equals(this.typeId, channel.typeId) &&
                       Objects.equals(this.userIconId, channel.userIconId) &&
                       Objects.equals(this.connected, channel.connected) &&
                       Objects.equals(this.state, channel.state) &&
                       Objects.equals(this.supportedFunctions, channel.supportedFunctions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, channelNumber, caption, type, function, param1, param2, param3, textParam1, textParam2, textParam3, altIcon, hidden, inheritedLocation, iodeviceId, locationId, functionId, typeId, userIconId, connected, state, supportedFunctions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Channel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    channelNumber: ").append(toIndentedString(channelNumber)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    function: ").append(toIndentedString(function)).append("\n");
        sb.append("    param1: ").append(toIndentedString(param1)).append("\n");
        sb.append("    param2: ").append(toIndentedString(param2)).append("\n");
        sb.append("    param3: ").append(toIndentedString(param3)).append("\n");
        sb.append("    textParam1: ").append(toIndentedString(textParam1)).append("\n");
        sb.append("    textParam2: ").append(toIndentedString(textParam2)).append("\n");
        sb.append("    textParam3: ").append(toIndentedString(textParam3)).append("\n");
        sb.append("    altIcon: ").append(toIndentedString(altIcon)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
        sb.append("    inheritedLocation: ").append(toIndentedString(inheritedLocation)).append("\n");
        sb.append("    iodeviceId: ").append(toIndentedString(iodeviceId)).append("\n");
        sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
        sb.append("    functionId: ").append(toIndentedString(functionId)).append("\n");
        sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
        sb.append("    userIconId: ").append(toIndentedString(userIconId)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    supportedFunctions: ").append(toIndentedString(supportedFunctions)).append("\n");
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
