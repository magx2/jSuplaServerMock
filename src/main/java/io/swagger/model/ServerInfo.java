package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ServerInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ServerInfo {
    @JsonProperty("address")
    private String address = null;

    @JsonProperty("time")
    private OffsetDateTime time = null;

    @JsonProperty("timezone")
    private ServerInfoTimezone timezone = null;

    @JsonProperty("authenticated")
    private Boolean authenticated = null;

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("cloudVersion")
    private String cloudVersion = null;

    @JsonProperty("apiVersion")
    private String apiVersion = null;

    @JsonProperty("supportedApiVersions")
    @Valid
    private List<String> supportedApiVersions = null;

    public ServerInfo address(String address) {
        this.address = address;
        return this;
    }

    /**
     * SUPLA Server address (to be used in smartphones)
     *
     * @return address
     **/
    @ApiModelProperty(example = "svr1.supla.org", value = "SUPLA Server address (to be used in smartphones)")

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ServerInfo time(OffsetDateTime time) {
        this.time = time;
        return this;
    }

    /**
     * Current server time
     *
     * @return time
     **/
    @ApiModelProperty(value = "Current server time")

    @Valid
    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public ServerInfo timezone(ServerInfoTimezone timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * Get timezone
     *
     * @return timezone
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ServerInfoTimezone getTimezone() {
        return timezone;
    }

    public void setTimezone(ServerInfoTimezone timezone) {
        this.timezone = timezone;
    }

    public ServerInfo authenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    /**
     * Get authenticated
     *
     * @return authenticated
     **/
    @ApiModelProperty(value = "")

    public Boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public ServerInfo username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Present only if `authenticated=true`
     *
     * @return username
     **/
    @ApiModelProperty(example = "supler@supla.org", value = "Present only if `authenticated=true`")

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ServerInfo cloudVersion(String cloudVersion) {
        this.cloudVersion = cloudVersion;
        return this;
    }

    /**
     * Get cloudVersion
     *
     * @return cloudVersion
     **/
    @ApiModelProperty(example = "2.2.0", value = "")

    public String getCloudVersion() {
        return cloudVersion;
    }

    public void setCloudVersion(String cloudVersion) {
        this.cloudVersion = cloudVersion;
    }

    public ServerInfo apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * Get apiVersion
     *
     * @return apiVersion
     **/
    @ApiModelProperty(example = "2.2.0", value = "")

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public ServerInfo supportedApiVersions(List<String> supportedApiVersions) {
        this.supportedApiVersions = supportedApiVersions;
        return this;
    }

    public ServerInfo addSupportedApiVersionsItem(String supportedApiVersionsItem) {
        if (this.supportedApiVersions == null) {
            this.supportedApiVersions = new ArrayList<String>();
        }
        this.supportedApiVersions.add(supportedApiVersionsItem);
        return this;
    }

    /**
     * Get supportedApiVersions
     *
     * @return supportedApiVersions
     **/
    @ApiModelProperty(example = "[\"2.0.0\",\"2.1.0\",\"2.2.0\"]", value = "")

    public List<String> getSupportedApiVersions() {
        return supportedApiVersions;
    }

    public void setSupportedApiVersions(List<String> supportedApiVersions) {
        this.supportedApiVersions = supportedApiVersions;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerInfo serverInfo = (ServerInfo) o;
        return Objects.equals(this.address, serverInfo.address) &&
                       Objects.equals(this.time, serverInfo.time) &&
                       Objects.equals(this.timezone, serverInfo.timezone) &&
                       Objects.equals(this.authenticated, serverInfo.authenticated) &&
                       Objects.equals(this.username, serverInfo.username) &&
                       Objects.equals(this.cloudVersion, serverInfo.cloudVersion) &&
                       Objects.equals(this.apiVersion, serverInfo.apiVersion) &&
                       Objects.equals(this.supportedApiVersions, serverInfo.supportedApiVersions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, time, timezone, authenticated, username, cloudVersion, apiVersion, supportedApiVersions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServerInfo {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
        sb.append("    authenticated: ").append(toIndentedString(authenticated)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    cloudVersion: ").append(toIndentedString(cloudVersion)).append("\n");
        sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
        sb.append("    supportedApiVersions: ").append(toIndentedString(supportedApiVersions)).append("\n");
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
