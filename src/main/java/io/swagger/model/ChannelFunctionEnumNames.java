package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ChannelFunctionEnumNames
 */
public enum ChannelFunctionEnumNames {
    NONE("NONE"),
    CONTROLLINGTHEGATEWAYLOCK("CONTROLLINGTHEGATEWAYLOCK"),
    CONTROLLINGTHEGATE("CONTROLLINGTHEGATE"),
    CONTROLLINGTHEGARAGEDOOR("CONTROLLINGTHEGARAGEDOOR"),
    THERMOMETER("THERMOMETER"),
    HUMIDITY("HUMIDITY"),
    HUMIDITYANDTEMPERATURE("HUMIDITYANDTEMPERATURE"),
    OPENINGSENSOR_GATEWAY("OPENINGSENSOR_GATEWAY"),
    OPENINGSENSOR_GATE("OPENINGSENSOR_GATE"),
    OPENINGSENSOR_GARAGEDOOR("OPENINGSENSOR_GARAGEDOOR"),
    NOLIQUIDSENSOR("NOLIQUIDSENSOR"),
    CONTROLLINGTHEDOORLOCK("CONTROLLINGTHEDOORLOCK"),
    OPENINGSENSOR_DOOR("OPENINGSENSOR_DOOR"),
    CONTROLLINGTHEROLLERSHUTTER("CONTROLLINGTHEROLLERSHUTTER"),
    OPENINGSENSOR_ROLLERSHUTTER("OPENINGSENSOR_ROLLERSHUTTER"),
    POWERSWITCH("POWERSWITCH"),
    LIGHTSWITCH("LIGHTSWITCH"),
    DIMMER("DIMMER"),
    RGBLIGHTING("RGBLIGHTING"),
    DIMMERANDRGBLIGHTING("DIMMERANDRGBLIGHTING"),
    DEPTHSENSOR("DEPTHSENSOR"),
    DISTANCESENSOR("DISTANCESENSOR"),
    OPENINGSENSOR_WINDOW("OPENINGSENSOR_WINDOW"),
    MAILSENSOR("MAILSENSOR"),
    WINDSENSOR("WINDSENSOR"),
    PRESSURESENSOR("PRESSURESENSOR"),
    RAINSENSOR("RAINSENSOR"),
    WEIGHTSENSOR("WEIGHTSENSOR"),
    WEATHER_STATION("WEATHER_STATION"),
    STAIRCASETIMER("STAIRCASETIMER");

    private String value;

    ChannelFunctionEnumNames(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ChannelFunctionEnumNames fromValue(String text) {
        for (ChannelFunctionEnumNames b : ChannelFunctionEnumNames.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
