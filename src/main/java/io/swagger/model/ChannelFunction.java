package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ChannelFunction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelFunction {
    /**
     * Gets or Sets id
     */
    public enum IdEnum {
        NUMBER_0(0),

        NUMBER_10(10),

        NUMBER_20(20),

        NUMBER_30(30),

        NUMBER_40(40),

        NUMBER_42(42),

        NUMBER_45(45),

        NUMBER_50(50),

        NUMBER_60(60),

        NUMBER_70(70),

        NUMBER_80(80),

        NUMBER_90(90),

        NUMBER_100(100),

        NUMBER_110(110),

        NUMBER_120(120),

        NUMBER_130(130),

        NUMBER_140(140),

        NUMBER_180(180),

        NUMBER_190(190),

        NUMBER_200(200),

        NUMBER_210(210),

        NUMBER_220(220),

        NUMBER_230(230),

        NUMBER_240(240),

        NUMBER_250(250),

        NUMBER_260(260),

        NUMBER_270(270),

        NUMBER_280(280),

        NUMBER_290(290),

        NUMBER_300(300);

        private Integer value;

        IdEnum(Integer value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static IdEnum fromValue(String text) {
            for (IdEnum b : IdEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("id")
    private IdEnum id = null;

    @JsonProperty("name")
    private ChannelFunctionEnumNames name = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("maxAlternativeIconIndex")
    private Integer maxAlternativeIconIndex = null;

    @JsonProperty("possibleActions")
    @Valid
    private List<ChannelFunctionAction> possibleActions = null;

    /**
     * Gets or Sets possibleVisualStates
     */
    public enum PossibleVisualStatesEnum {
        OPENED("opened"),

        CLOSED("closed"),

        PARTIALLY_CLOSED("partially_closed"),

        DEFAULT("default"),

        EMPTY("empty"),

        FULL("full"),

        REVEALED("revealed"),

        SHUT("shut"),

        ON("on"),

        OFF("off"),

        RGB_ON_DIM_ON("rgb_on_dim_on"),

        RGB_ON_DIM_OFF("rgb_on_dim_off"),

        RGB_OFF_DIM_OFF("rgb_off_dim_off"),

        RGB_OFF_DIM_ON("rgb_off_dim_on");

        private String value;

        PossibleVisualStatesEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static PossibleVisualStatesEnum fromValue(String text) {
            for (PossibleVisualStatesEnum b : PossibleVisualStatesEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("possibleVisualStates")
    @Valid
    private List<PossibleVisualStatesEnum> possibleVisualStates = null;

    public ChannelFunction id(IdEnum id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(example = "60", value = "")

    public IdEnum getId() {
        return id;
    }

    public void setId(IdEnum id) {
        this.id = id;
    }

    public ChannelFunction name(ChannelFunctionEnumNames name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ChannelFunctionEnumNames getName() {
        return name;
    }

    public void setName(ChannelFunctionEnumNames name) {
        this.name = name;
    }

    public ChannelFunction caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Get caption
     *
     * @return caption
     **/
    @ApiModelProperty(example = "Gate opening sensor", value = "")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ChannelFunction maxAlternativeIconIndex(Integer maxAlternativeIconIndex) {
        this.maxAlternativeIconIndex = maxAlternativeIconIndex;
        return this;
    }

    /**
     * Get maxAlternativeIconIndex
     *
     * @return maxAlternativeIconIndex
     **/
    @ApiModelProperty(value = "")

    public Integer getMaxAlternativeIconIndex() {
        return maxAlternativeIconIndex;
    }

    public void setMaxAlternativeIconIndex(Integer maxAlternativeIconIndex) {
        this.maxAlternativeIconIndex = maxAlternativeIconIndex;
    }

    public ChannelFunction possibleActions(List<ChannelFunctionAction> possibleActions) {
        this.possibleActions = possibleActions;
        return this;
    }

    public ChannelFunction addPossibleActionsItem(ChannelFunctionAction possibleActionsItem) {
        if (this.possibleActions == null) {
            this.possibleActions = new ArrayList<ChannelFunctionAction>();
        }
        this.possibleActions.add(possibleActionsItem);
        return this;
    }

    /**
     * What can you with with this channel?
     *
     * @return possibleActions
     **/
    @ApiModelProperty(value = "What can you with with this channel?")
    @Valid
    public List<ChannelFunctionAction> getPossibleActions() {
        return possibleActions;
    }

    public void setPossibleActions(List<ChannelFunctionAction> possibleActions) {
        this.possibleActions = possibleActions;
    }

    public ChannelFunction possibleVisualStates(List<PossibleVisualStatesEnum> possibleVisualStates) {
        this.possibleVisualStates = possibleVisualStates;
        return this;
    }

    public ChannelFunction addPossibleVisualStatesItem(PossibleVisualStatesEnum possibleVisualStatesItem) {
        if (this.possibleVisualStates == null) {
            this.possibleVisualStates = new ArrayList<PossibleVisualStatesEnum>();
        }
        this.possibleVisualStates.add(possibleVisualStatesItem);
        return this;
    }

    /**
     * Possible visual states of channel with this function. Ordered.
     *
     * @return possibleVisualStates
     **/
    @ApiModelProperty(value = "Possible visual states of channel with this function. Ordered.")

    public List<PossibleVisualStatesEnum> getPossibleVisualStates() {
        return possibleVisualStates;
    }

    public void setPossibleVisualStates(List<PossibleVisualStatesEnum> possibleVisualStates) {
        this.possibleVisualStates = possibleVisualStates;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelFunction channelFunction = (ChannelFunction) o;
        return Objects.equals(this.id, channelFunction.id) &&
                       Objects.equals(this.name, channelFunction.name) &&
                       Objects.equals(this.caption, channelFunction.caption) &&
                       Objects.equals(this.maxAlternativeIconIndex, channelFunction.maxAlternativeIconIndex) &&
                       Objects.equals(this.possibleActions, channelFunction.possibleActions) &&
                       Objects.equals(this.possibleVisualStates, channelFunction.possibleVisualStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, caption, maxAlternativeIconIndex, possibleActions, possibleVisualStates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelFunction {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    maxAlternativeIconIndex: ").append(toIndentedString(maxAlternativeIconIndex)).append("\n");
        sb.append("    possibleActions: ").append(toIndentedString(possibleActions)).append("\n");
        sb.append("    possibleVisualStates: ").append(toIndentedString(possibleVisualStates)).append("\n");
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
