package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * UserUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class UserUpdateRequest {
    /**
     * The `change:userTimezone` requires to provide also a `timezone` value in the request. The `change:password` requires to provide also a `newPassword` and `oldPassword` in the request.
     */
    public enum ActionEnum {
        CHANGE_CLIENTSREGISTRATIONENABLED("change:clientsRegistrationEnabled"),

        CHANGE_IODEVICESREGISTRATIONENABLED("change:ioDevicesRegistrationEnabled"),

        CHANGE_USERTIMEZONE("change:userTimezone"),

        CHANGE_PASSWORD("change:password"),

        AGREE_RULES("agree:rules"),

        AGREE_COOKIES("agree:cookies");

        private String value;

        ActionEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ActionEnum fromValue(String text) {
            for (ActionEnum b : ActionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("action")
    private ActionEnum action = null;

    public UserUpdateRequest action(ActionEnum action) {
        this.action = action;
        return this;
    }

    /**
     * The `change:userTimezone` requires to provide also a `timezone` value in the request. The `change:password` requires to provide also a `newPassword` and `oldPassword` in the request.
     *
     * @return action
     **/
    @ApiModelProperty(value = "The `change:userTimezone` requires to provide also a `timezone` value in the request. The `change:password` requires to provide also a `newPassword` and `oldPassword` in the request.")

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserUpdateRequest userUpdateRequest = (UserUpdateRequest) o;
        return Objects.equals(this.action, userUpdateRequest.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserUpdateRequest {\n");

        sb.append("    action: ").append(toIndentedString(action)).append("\n");
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
