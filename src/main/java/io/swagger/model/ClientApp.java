package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ClientApp
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ClientApp {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("regIpv4")
    private Long regIpv4 = null;

    @JsonProperty("regDate")
    private OffsetDateTime regDate = null;

    @JsonProperty("lastAccessIpv4")
    private Long lastAccessIpv4 = null;

    @JsonProperty("lastAccessDate")
    private OffsetDateTime lastAccessDate = null;

    @JsonProperty("softwareVersion")
    private String softwareVersion = null;

    @JsonProperty("protocolVersion")
    private Integer protocolVersion = null;

    @JsonProperty("accessIdId")
    private Integer accessIdId = null;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("accessId")
    private AccessIdentifier accessId = null;

    public ClientApp id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Client application identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Client application identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientApp name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientApp caption(String caption) {
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

    public ClientApp enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    @ApiModelProperty(value = "")

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public ClientApp regIpv4(Long regIpv4) {
        this.regIpv4 = regIpv4;
        return this;
    }

    /**
     * Get regIpv4
     *
     * @return regIpv4
     **/
    @ApiModelProperty(value = "")

    public Long getRegIpv4() {
        return regIpv4;
    }

    public void setRegIpv4(Long regIpv4) {
        this.regIpv4 = regIpv4;
    }

    public ClientApp regDate(OffsetDateTime regDate) {
        this.regDate = regDate;
        return this;
    }

    /**
     * Get regDate
     *
     * @return regDate
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(OffsetDateTime regDate) {
        this.regDate = regDate;
    }

    public ClientApp lastAccessIpv4(Long lastAccessIpv4) {
        this.lastAccessIpv4 = lastAccessIpv4;
        return this;
    }

    /**
     * Get lastAccessIpv4
     *
     * @return lastAccessIpv4
     **/
    @ApiModelProperty(value = "")

    public Long getLastAccessIpv4() {
        return lastAccessIpv4;
    }

    public void setLastAccessIpv4(Long lastAccessIpv4) {
        this.lastAccessIpv4 = lastAccessIpv4;
    }

    public ClientApp lastAccessDate(OffsetDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
        return this;
    }

    /**
     * Get lastAccessDate
     *
     * @return lastAccessDate
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(OffsetDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public ClientApp softwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    /**
     * Get softwareVersion
     *
     * @return softwareVersion
     **/
    @ApiModelProperty(value = "")

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public ClientApp protocolVersion(Integer protocolVersion) {
        this.protocolVersion = protocolVersion;
        return this;
    }

    /**
     * Get protocolVersion
     *
     * @return protocolVersion
     **/
    @ApiModelProperty(value = "")

    public Integer getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(Integer protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public ClientApp accessIdId(Integer accessIdId) {
        this.accessIdId = accessIdId;
        return this;
    }

    /**
     * Get accessIdId
     *
     * @return accessIdId
     **/
    @ApiModelProperty(value = "")

    public Integer getAccessIdId() {
        return accessIdId;
    }

    public void setAccessIdId(Integer accessIdId) {
        this.accessIdId = accessIdId;
    }

    public ClientApp connected(Boolean connected) {
        this.connected = connected;
        return this;
    }

    /**
     * Get connected
     *
     * @return connected
     **/
    @ApiModelProperty(value = "")

    public Boolean isConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public ClientApp accessId(AccessIdentifier accessId) {
        this.accessId = accessId;
        return this;
    }

    /**
     * Get accessId
     *
     * @return accessId
     **/
    @ApiModelProperty(value = "")

    @Valid
    public AccessIdentifier getAccessId() {
        return accessId;
    }

    public void setAccessId(AccessIdentifier accessId) {
        this.accessId = accessId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClientApp clientApp = (ClientApp) o;
        return Objects.equals(this.id, clientApp.id) &&
                       Objects.equals(this.name, clientApp.name) &&
                       Objects.equals(this.caption, clientApp.caption) &&
                       Objects.equals(this.enabled, clientApp.enabled) &&
                       Objects.equals(this.regIpv4, clientApp.regIpv4) &&
                       Objects.equals(this.regDate, clientApp.regDate) &&
                       Objects.equals(this.lastAccessIpv4, clientApp.lastAccessIpv4) &&
                       Objects.equals(this.lastAccessDate, clientApp.lastAccessDate) &&
                       Objects.equals(this.softwareVersion, clientApp.softwareVersion) &&
                       Objects.equals(this.protocolVersion, clientApp.protocolVersion) &&
                       Objects.equals(this.accessIdId, clientApp.accessIdId) &&
                       Objects.equals(this.connected, clientApp.connected) &&
                       Objects.equals(this.accessId, clientApp.accessId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, caption, enabled, regIpv4, regDate, lastAccessIpv4, lastAccessDate, softwareVersion, protocolVersion, accessIdId, connected, accessId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClientApp {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    regIpv4: ").append(toIndentedString(regIpv4)).append("\n");
        sb.append("    regDate: ").append(toIndentedString(regDate)).append("\n");
        sb.append("    lastAccessIpv4: ").append(toIndentedString(lastAccessIpv4)).append("\n");
        sb.append("    lastAccessDate: ").append(toIndentedString(lastAccessDate)).append("\n");
        sb.append("    softwareVersion: ").append(toIndentedString(softwareVersion)).append("\n");
        sb.append("    protocolVersion: ").append(toIndentedString(protocolVersion)).append("\n");
        sb.append("    accessIdId: ").append(toIndentedString(accessIdId)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    accessId: ").append(toIndentedString(accessId)).append("\n");
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
