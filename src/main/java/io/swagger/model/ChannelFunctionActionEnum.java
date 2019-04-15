package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ChannelFunctionActionEnum
 */
public enum ChannelFunctionActionEnum {
    OPEN("OPEN"),
    CLOSE("CLOSE"),
    SHUT("SHUT"),
    REVEAL("REVEAL"),
    REVEAL_PARTIALLY("REVEAL_PARTIALLY"),
    TURN_ON("TURN_ON"),
    TURN_OFF("TURN_OFF"),
    SET_RGBW_PARAMETERS("SET_RGBW_PARAMETERS"),
    OPEN_CLOSE("OPEN_CLOSE"),
    STOP("STOP"),
    TOGGLE("TOGGLE"),
    READ("READ");

    private String value;

    ChannelFunctionActionEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ChannelFunctionActionEnum fromValue(String text) {
        for (ChannelFunctionActionEnum b : ChannelFunctionActionEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
