package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * AuditEntry
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class AuditEntry {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("event")
    private Integer event = null;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt = null;

    @JsonProperty("ipv4")
    private Long ipv4 = null;

    @JsonProperty("intParam")
    private Integer intParam = null;

    @JsonProperty("textParam")
    private String textParam = null;

    public AuditEntry id(Integer id) {
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

    public AuditEntry event(Integer event) {
        this.event = event;
        return this;
    }

    /**
     * Get event
     *
     * @return event
     **/
    @ApiModelProperty(value = "")

    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

    public AuditEntry createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AuditEntry ipv4(Long ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

    /**
     * Get ipv4
     *
     * @return ipv4
     **/
    @ApiModelProperty(value = "")

    public Long getIpv4() {
        return ipv4;
    }

    public void setIpv4(Long ipv4) {
        this.ipv4 = ipv4;
    }

    public AuditEntry intParam(Integer intParam) {
        this.intParam = intParam;
        return this;
    }

    /**
     * Get intParam
     *
     * @return intParam
     **/
    @ApiModelProperty(value = "")

    public Integer getIntParam() {
        return intParam;
    }

    public void setIntParam(Integer intParam) {
        this.intParam = intParam;
    }

    public AuditEntry textParam(String textParam) {
        this.textParam = textParam;
        return this;
    }

    /**
     * Get textParam
     *
     * @return textParam
     **/
    @ApiModelProperty(value = "")

    public String getTextParam() {
        return textParam;
    }

    public void setTextParam(String textParam) {
        this.textParam = textParam;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuditEntry auditEntry = (AuditEntry) o;
        return Objects.equals(this.id, auditEntry.id) &&
                       Objects.equals(this.event, auditEntry.event) &&
                       Objects.equals(this.createdAt, auditEntry.createdAt) &&
                       Objects.equals(this.ipv4, auditEntry.ipv4) &&
                       Objects.equals(this.intParam, auditEntry.intParam) &&
                       Objects.equals(this.textParam, auditEntry.textParam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, createdAt, ipv4, intParam, textParam);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuditEntry {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    event: ").append(toIndentedString(event)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    ipv4: ").append(toIndentedString(ipv4)).append("\n");
        sb.append("    intParam: ").append(toIndentedString(intParam)).append("\n");
        sb.append("    textParam: ").append(toIndentedString(textParam)).append("\n");
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
