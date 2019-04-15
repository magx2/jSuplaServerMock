package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ChannelExecuteActionRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelExecuteActionRequest {
    @JsonProperty("action")
    private ChannelFunctionActionEnum action = null;

    @JsonProperty("percentage")
    private Integer percentage = null;

    @JsonProperty("color")
    private String color = null;

    @JsonProperty("color_brightness")
    private Integer colorBrightness = null;

    @JsonProperty("brightness")
    private Integer brightness = null;

    public ChannelExecuteActionRequest action(ChannelFunctionActionEnum action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ChannelFunctionActionEnum getAction() {
        return action;
    }

    public void setAction(ChannelFunctionActionEnum action) {
        this.action = action;
    }

    public ChannelExecuteActionRequest percentage(Integer percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Get percentage
     *
     * @return percentage
     **/
    @ApiModelProperty(example = "40", value = "")

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public ChannelExecuteActionRequest color(String color) {
        this.color = color;
        return this;
    }

    /**
     * Get color
     *
     * @return color
     **/
    @ApiModelProperty(example = "0x00FF00", value = "")

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ChannelExecuteActionRequest colorBrightness(Integer colorBrightness) {
        this.colorBrightness = colorBrightness;
        return this;
    }

    /**
     * Get colorBrightness
     *
     * @return colorBrightness
     **/
    @ApiModelProperty(value = "")

    public Integer getColorBrightness() {
        return colorBrightness;
    }

    public void setColorBrightness(Integer colorBrightness) {
        this.colorBrightness = colorBrightness;
    }

    public ChannelExecuteActionRequest brightness(Integer brightness) {
        this.brightness = brightness;
        return this;
    }

    /**
     * Get brightness
     *
     * @return brightness
     **/
    @ApiModelProperty(value = "")

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelExecuteActionRequest channelExecuteActionRequest = (ChannelExecuteActionRequest) o;
        return Objects.equals(this.action, channelExecuteActionRequest.action) &&
                       Objects.equals(this.percentage, channelExecuteActionRequest.percentage) &&
                       Objects.equals(this.color, channelExecuteActionRequest.color) &&
                       Objects.equals(this.colorBrightness, channelExecuteActionRequest.colorBrightness) &&
                       Objects.equals(this.brightness, channelExecuteActionRequest.brightness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, percentage, color, colorBrightness, brightness);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelExecuteActionRequest {\n");

        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
        sb.append("    color: ").append(toIndentedString(color)).append("\n");
        sb.append("    colorBrightness: ").append(toIndentedString(colorBrightness)).append("\n");
        sb.append("    brightness: ").append(toIndentedString(brightness)).append("\n");
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
