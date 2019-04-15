package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ChannelFunctionAction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelFunctionAction {
    /**
     * Gets or Sets id
     */
    public enum IdEnum {
        NUMBER_10(10),

        NUMBER_20(20),

        NUMBER_30(30),

        NUMBER_40(40),

        NUMBER_50(50),

        NUMBER_60(60),

        NUMBER_70(70),

        NUMBER_80(80),

        NUMBER_90(90),

        NUMBER_100(100);

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
    private ChannelFunctionActionEnum name = null;

    @JsonProperty("caption")
    private String caption = null;

    public ChannelFunctionAction id(IdEnum id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")

    public IdEnum getId() {
        return id;
    }

    public void setId(IdEnum id) {
        this.id = id;
    }

    public ChannelFunctionAction name(ChannelFunctionActionEnum name) {
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
    public ChannelFunctionActionEnum getName() {
        return name;
    }

    public void setName(ChannelFunctionActionEnum name) {
        this.name = name;
    }

    public ChannelFunctionAction caption(String caption) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelFunctionAction channelFunctionAction = (ChannelFunctionAction) o;
        return Objects.equals(this.id, channelFunctionAction.id) &&
                       Objects.equals(this.name, channelFunctionAction.name) &&
                       Objects.equals(this.caption, channelFunctionAction.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, caption);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelFunctionAction {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
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
