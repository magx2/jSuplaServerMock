package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ActionableSubjectTypeEnum
 */
public enum ActionableSubjectTypeEnum {
    CHANNEL("channel"),
    CHANNELGROUP("channelGroup");

    private String value;

    ActionableSubjectTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ActionableSubjectTypeEnum fromValue(String text) {
        for (ActionableSubjectTypeEnum b : ActionableSubjectTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
