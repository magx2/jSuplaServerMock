package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ChannelType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelType {
    /**
     * Channel type identifier
     */
    public enum IdEnum {
        NUMBER_1000(1000),

        NUMBER_1010(1010),

        NUMBER_1020(1020),

        NUMBER_1500(1500),

        NUMBER_2000(2000),

        NUMBER_2010(2010),

        NUMBER_2020(2020),

        NUMBER_2900(2900),

        NUMBER_3000(3000),

        NUMBER_3010(3010),

        NUMBER_3022(3022),

        NUMBER_3020(3020),

        NUMBER_3032(3032),

        NUMBER_3030(3030),

        NUMBER_3034(3034),

        NUMBER_3036(3036),

        NUMBER_3038(3038),

        NUMBER_3042(3042),

        NUMBER_3044(3044),

        NUMBER_3048(3048),

        NUMBER_3050(3050),

        NUMBER_3100(3100),

        NUMBER_4000(4000),

        NUMBER_4010(4010),

        NUMBER_4020(4020);

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

    /**
     * Gets or Sets name
     */
    public enum NameEnum {
        SENSORNO("SENSORNO"),

        SENSORNC("SENSORNC"),

        DISTANCESENSOR("DISTANCESENSOR"),

        CALLBUTTON("CALLBUTTON"),

        RELAYHFD4("RELAYHFD4"),

        RELAYG5LA1A("RELAYG5LA1A"),

        RELAY2XG5LA1A("RELAY2XG5LA1A"),

        RELAY("RELAY"),

        THERMOMETERDS18B20("THERMOMETERDS18B20"),

        DHT11("DHT11"),

        DHT21("DHT21"),

        DHT22("DHT22"),

        AM2301("AM2301"),

        AM2302("AM2302"),

        THERMOMETER("THERMOMETER"),

        HUMIDITYSENSOR("HUMIDITYSENSOR"),

        HUMIDITYANDTEMPSENSOR("HUMIDITYANDTEMPSENSOR"),

        WINDSENSOR("WINDSENSOR"),

        PRESSURESENSOR("PRESSURESENSOR"),

        RAINSENSOR("RAINSENSOR"),

        WEIGHTSENSOR("WEIGHTSENSOR"),

        WEATHER_STATION("WEATHER_STATION"),

        DIMMER("DIMMER"),

        RGBLEDCONTROLLER("RGBLEDCONTROLLER"),

        DIMMERANDRGBLED("DIMMERANDRGBLED");

        private String value;

        NameEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static NameEnum fromValue(String text) {
            for (NameEnum b : NameEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("name")
    private NameEnum name = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("output")
    private Boolean output = null;

    public ChannelType id(IdEnum id) {
        this.id = id;
        return this;
    }

    /**
     * Channel type identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Channel type identifier")

    public IdEnum getId() {
        return id;
    }

    public void setId(IdEnum id) {
        this.id = id;
    }

    public ChannelType name(NameEnum name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")

    public NameEnum getName() {
        return name;
    }

    public void setName(NameEnum name) {
        this.name = name;
    }

    public ChannelType caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Get caption
     *
     * @return caption
     **/
    @ApiModelProperty(example = "Sensor (normal open)", value = "")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ChannelType output(Boolean output) {
        this.output = output;
        return this;
    }

    /**
     * Whether the channel is output type (i.e. can take action) or input (i.e. provide data)
     *
     * @return output
     **/
    @ApiModelProperty(example = "false", value = "Whether the channel is output type (i.e. can take action) or input (i.e. provide data)")

    public Boolean isOutput() {
        return output;
    }

    public void setOutput(Boolean output) {
        this.output = output;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelType channelType = (ChannelType) o;
        return Objects.equals(this.id, channelType.id) &&
                       Objects.equals(this.name, channelType.name) &&
                       Objects.equals(this.caption, channelType.caption) &&
                       Objects.equals(this.output, channelType.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, caption, output);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelType {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
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
