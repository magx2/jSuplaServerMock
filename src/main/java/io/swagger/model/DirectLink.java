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
 * DirectLink
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class DirectLink {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("executionsLimit")
    private Integer executionsLimit = null;

    @JsonProperty("lastUsed")
    private OffsetDateTime lastUsed = null;

    @JsonProperty("lastIpv4")
    private Long lastIpv4 = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("disableHttpGet")
    private Boolean disableHttpGet = null;

    @JsonProperty("activeDateRange")
    private DirectLinkActiveDateRange activeDateRange = null;

    @JsonProperty("slug")
    private String slug = null;

    @JsonProperty("url")
    private String url = null;

    @JsonProperty("subjectId")
    private Integer subjectId = null;

    @JsonProperty("subjectType")
    private ActionableSubjectTypeEnum subjectType = null;

    @JsonProperty("allowedActions")
    @Valid
    private List<ChannelFunctionActionEnum> allowedActions = null;

    @JsonProperty("active")
    private Boolean active = null;

    @JsonProperty("inactiveReason")
    private String inactiveReason = null;

    public DirectLink id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Direct Link identifier
     *
     * @return id
     **/
    @ApiModelProperty(example = "1", value = "Direct Link identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DirectLink caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Direct Link caption
     *
     * @return caption
     **/
    @ApiModelProperty(value = "Direct Link caption")

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public DirectLink executionsLimit(Integer executionsLimit) {
        this.executionsLimit = executionsLimit;
        return this;
    }

    /**
     * Get executionsLimit
     *
     * @return executionsLimit
     **/
    @ApiModelProperty(example = "10", value = "")

    public Integer getExecutionsLimit() {
        return executionsLimit;
    }

    public void setExecutionsLimit(Integer executionsLimit) {
        this.executionsLimit = executionsLimit;
    }

    public DirectLink lastUsed(OffsetDateTime lastUsed) {
        this.lastUsed = lastUsed;
        return this;
    }

    /**
     * Get lastUsed
     *
     * @return lastUsed
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(OffsetDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    public DirectLink lastIpv4(Long lastIpv4) {
        this.lastIpv4 = lastIpv4;
        return this;
    }

    /**
     * Get lastIpv4
     *
     * @return lastIpv4
     **/
    @ApiModelProperty(value = "")

    public Long getLastIpv4() {
        return lastIpv4;
    }

    public void setLastIpv4(Long lastIpv4) {
        this.lastIpv4 = lastIpv4;
    }

    public DirectLink enabled(Boolean enabled) {
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

    public DirectLink disableHttpGet(Boolean disableHttpGet) {
        this.disableHttpGet = disableHttpGet;
        return this;
    }

    /**
     * Get disableHttpGet
     *
     * @return disableHttpGet
     **/
    @ApiModelProperty(value = "")

    public Boolean isDisableHttpGet() {
        return disableHttpGet;
    }

    public void setDisableHttpGet(Boolean disableHttpGet) {
        this.disableHttpGet = disableHttpGet;
    }

    public DirectLink activeDateRange(DirectLinkActiveDateRange activeDateRange) {
        this.activeDateRange = activeDateRange;
        return this;
    }

    /**
     * Get activeDateRange
     *
     * @return activeDateRange
     **/
    @ApiModelProperty(value = "")

    @Valid
    public DirectLinkActiveDateRange getActiveDateRange() {
        return activeDateRange;
    }

    public void setActiveDateRange(DirectLinkActiveDateRange activeDateRange) {
        this.activeDateRange = activeDateRange;
    }

    public DirectLink slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * Returned only immediately after creation
     *
     * @return slug
     **/
    @ApiModelProperty(value = "Returned only immediately after creation")

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public DirectLink url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Returned only immediately after creation
     *
     * @return url
     **/
    @ApiModelProperty(value = "Returned only immediately after creation")

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DirectLink subjectId(Integer subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    /**
     * Get subjectId
     *
     * @return subjectId
     **/
    @ApiModelProperty(value = "")

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public DirectLink subjectType(ActionableSubjectTypeEnum subjectType) {
        this.subjectType = subjectType;
        return this;
    }

    /**
     * Get subjectType
     *
     * @return subjectType
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ActionableSubjectTypeEnum getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(ActionableSubjectTypeEnum subjectType) {
        this.subjectType = subjectType;
    }

    public DirectLink allowedActions(List<ChannelFunctionActionEnum> allowedActions) {
        this.allowedActions = allowedActions;
        return this;
    }

    public DirectLink addAllowedActionsItem(ChannelFunctionActionEnum allowedActionsItem) {
        if (this.allowedActions == null) {
            this.allowedActions = new ArrayList<ChannelFunctionActionEnum>();
        }
        this.allowedActions.add(allowedActionsItem);
        return this;
    }

    /**
     * Get allowedActions
     *
     * @return allowedActions
     **/
    @ApiModelProperty(value = "")
    @Valid
    public List<ChannelFunctionActionEnum> getAllowedActions() {
        return allowedActions;
    }

    public void setAllowedActions(List<ChannelFunctionActionEnum> allowedActions) {
        this.allowedActions = allowedActions;
    }

    public DirectLink active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Get active
     *
     * @return active
     **/
    @ApiModelProperty(value = "")

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DirectLink inactiveReason(String inactiveReason) {
        this.inactiveReason = inactiveReason;
        return this;
    }

    /**
     * Returned only if active is `false`
     *
     * @return inactiveReason
     **/
    @ApiModelProperty(value = "Returned only if active is `false`")

    public String getInactiveReason() {
        return inactiveReason;
    }

    public void setInactiveReason(String inactiveReason) {
        this.inactiveReason = inactiveReason;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectLink directLink = (DirectLink) o;
        return Objects.equals(this.id, directLink.id) &&
                       Objects.equals(this.caption, directLink.caption) &&
                       Objects.equals(this.executionsLimit, directLink.executionsLimit) &&
                       Objects.equals(this.lastUsed, directLink.lastUsed) &&
                       Objects.equals(this.lastIpv4, directLink.lastIpv4) &&
                       Objects.equals(this.enabled, directLink.enabled) &&
                       Objects.equals(this.disableHttpGet, directLink.disableHttpGet) &&
                       Objects.equals(this.activeDateRange, directLink.activeDateRange) &&
                       Objects.equals(this.slug, directLink.slug) &&
                       Objects.equals(this.url, directLink.url) &&
                       Objects.equals(this.subjectId, directLink.subjectId) &&
                       Objects.equals(this.subjectType, directLink.subjectType) &&
                       Objects.equals(this.allowedActions, directLink.allowedActions) &&
                       Objects.equals(this.active, directLink.active) &&
                       Objects.equals(this.inactiveReason, directLink.inactiveReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caption, executionsLimit, lastUsed, lastIpv4, enabled, disableHttpGet, activeDateRange, slug, url, subjectId, subjectType, allowedActions, active, inactiveReason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectLink {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    executionsLimit: ").append(toIndentedString(executionsLimit)).append("\n");
        sb.append("    lastUsed: ").append(toIndentedString(lastUsed)).append("\n");
        sb.append("    lastIpv4: ").append(toIndentedString(lastIpv4)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    disableHttpGet: ").append(toIndentedString(disableHttpGet)).append("\n");
        sb.append("    activeDateRange: ").append(toIndentedString(activeDateRange)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
        sb.append("    subjectType: ").append(toIndentedString(subjectType)).append("\n");
        sb.append("    allowedActions: ").append(toIndentedString(allowedActions)).append("\n");
        sb.append("    active: ").append(toIndentedString(active)).append("\n");
        sb.append("    inactiveReason: ").append(toIndentedString(inactiveReason)).append("\n");
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
