package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * UserData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class UserData {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("shortUniqueId")
    private String shortUniqueId = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("timezone")
    private String timezone = null;

    @JsonProperty("clientsRegistrationEnabled")
    private OffsetDateTime clientsRegistrationEnabled = null;

    @JsonProperty("ioDevicesRegistrationEnabled")
    private OffsetDateTime ioDevicesRegistrationEnabled = null;

    public UserData id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserData shortUniqueId(String shortUniqueId) {
        this.shortUniqueId = shortUniqueId;
        return this;
    }

    /**
     * Get shortUniqueId
     *
     * @return shortUniqueId
     **/
    @ApiModelProperty(value = "")

    public String getShortUniqueId() {
        return shortUniqueId;
    }

    public void setShortUniqueId(String shortUniqueId) {
        this.shortUniqueId = shortUniqueId;
    }

    public UserData email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @ApiModelProperty(value = "")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserData timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * Get timezone
     *
     * @return timezone
     **/
    @ApiModelProperty(example = "Europe/Warsaw", value = "")

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public UserData clientsRegistrationEnabled(OffsetDateTime clientsRegistrationEnabled) {
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
        return this;
    }

    /**
     * Get clientsRegistrationEnabled
     *
     * @return clientsRegistrationEnabled
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getClientsRegistrationEnabled() {
        return clientsRegistrationEnabled;
    }

    public void setClientsRegistrationEnabled(OffsetDateTime clientsRegistrationEnabled) {
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
    }

    public UserData ioDevicesRegistrationEnabled(OffsetDateTime ioDevicesRegistrationEnabled) {
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
        return this;
    }

    /**
     * Get ioDevicesRegistrationEnabled
     *
     * @return ioDevicesRegistrationEnabled
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getIoDevicesRegistrationEnabled() {
        return ioDevicesRegistrationEnabled;
    }

    public void setIoDevicesRegistrationEnabled(OffsetDateTime ioDevicesRegistrationEnabled) {
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserData userData = (UserData) o;
        return Objects.equals(this.id, userData.id) &&
                       Objects.equals(this.shortUniqueId, userData.shortUniqueId) &&
                       Objects.equals(this.email, userData.email) &&
                       Objects.equals(this.timezone, userData.timezone) &&
                       Objects.equals(this.clientsRegistrationEnabled, userData.clientsRegistrationEnabled) &&
                       Objects.equals(this.ioDevicesRegistrationEnabled, userData.ioDevicesRegistrationEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortUniqueId, email, timezone, clientsRegistrationEnabled, ioDevicesRegistrationEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserData {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    shortUniqueId: ").append(toIndentedString(shortUniqueId)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
        sb.append("    clientsRegistrationEnabled: ").append(toIndentedString(clientsRegistrationEnabled)).append("\n");
        sb.append("    ioDevicesRegistrationEnabled: ").append(toIndentedString(ioDevicesRegistrationEnabled)).append("\n");
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
