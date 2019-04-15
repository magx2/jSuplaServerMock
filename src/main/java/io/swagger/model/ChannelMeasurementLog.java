package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ChannelMeasurementLog
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelMeasurementLog {
    @JsonProperty("date_timestamp")
    private Integer dateTimestamp = null;

    @JsonProperty("temperature")
    private Float temperature = null;

    @JsonProperty("humidity")
    private Float humidity = null;

    public ChannelMeasurementLog dateTimestamp(Integer dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
        return this;
    }

    /**
     * Get dateTimestamp
     *
     * @return dateTimestamp
     **/
    @ApiModelProperty(value = "")

    public Integer getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(Integer dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    public ChannelMeasurementLog temperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * Temperature in Celsius
     *
     * @return temperature
     **/
    @ApiModelProperty(example = "21.56", value = "Temperature in Celsius")

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public ChannelMeasurementLog humidity(Float humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * Humidity percent. Available only if channel function is `HUMIDITYANDTEMPERATURE`.
     *
     * @return humidity
     **/
    @ApiModelProperty(example = "48.8", value = "Humidity percent. Available only if channel function is `HUMIDITYANDTEMPERATURE`.")

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelMeasurementLog channelMeasurementLog = (ChannelMeasurementLog) o;
        return Objects.equals(this.dateTimestamp, channelMeasurementLog.dateTimestamp) &&
                       Objects.equals(this.temperature, channelMeasurementLog.temperature) &&
                       Objects.equals(this.humidity, channelMeasurementLog.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTimestamp, temperature, humidity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelMeasurementLog {\n");

        sb.append("    dateTimestamp: ").append(toIndentedString(dateTimestamp)).append("\n");
        sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
        sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
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
