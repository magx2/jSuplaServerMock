package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DirectLinkRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class DirectLinkRequest {
    @JsonProperty("subjectId")
    private Integer subjectId = null;

    @JsonProperty("subjectType")
    private ActionableSubjectTypeEnum subjectType = null;

    @JsonProperty("allowedActions")
    @Valid
    private List<ChannelFunctionActionEnum> allowedActions = null;

    @JsonProperty("activeDateRange")
    private DirectLinkActiveDateRange activeDateRange = null;

    @JsonProperty("executionsLimit")
    private Integer executionsLimit = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("disableHttpGet")
    private Boolean disableHttpGet = null;

    public DirectLinkRequest subjectId(Integer subjectId) {
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

    public DirectLinkRequest subjectType(ActionableSubjectTypeEnum subjectType) {
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

    public DirectLinkRequest allowedActions(List<ChannelFunctionActionEnum> allowedActions) {
        this.allowedActions = allowedActions;
        return this;
    }

    public DirectLinkRequest addAllowedActionsItem(ChannelFunctionActionEnum allowedActionsItem) {
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

    public DirectLinkRequest activeDateRange(DirectLinkActiveDateRange activeDateRange) {
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

    public DirectLinkRequest executionsLimit(Integer executionsLimit) {
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

    public DirectLinkRequest caption(String caption) {
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

    public DirectLinkRequest enabled(Boolean enabled) {
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

    public DirectLinkRequest disableHttpGet(Boolean disableHttpGet) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectLinkRequest directLinkRequest = (DirectLinkRequest) o;
        return Objects.equals(this.subjectId, directLinkRequest.subjectId) &&
                       Objects.equals(this.subjectType, directLinkRequest.subjectType) &&
                       Objects.equals(this.allowedActions, directLinkRequest.allowedActions) &&
                       Objects.equals(this.activeDateRange, directLinkRequest.activeDateRange) &&
                       Objects.equals(this.executionsLimit, directLinkRequest.executionsLimit) &&
                       Objects.equals(this.caption, directLinkRequest.caption) &&
                       Objects.equals(this.enabled, directLinkRequest.enabled) &&
                       Objects.equals(this.disableHttpGet, directLinkRequest.disableHttpGet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectType, allowedActions, activeDateRange, executionsLimit, caption, enabled, disableHttpGet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectLinkRequest {\n");

        sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
        sb.append("    subjectType: ").append(toIndentedString(subjectType)).append("\n");
        sb.append("    allowedActions: ").append(toIndentedString(allowedActions)).append("\n");
        sb.append("    activeDateRange: ").append(toIndentedString(activeDateRange)).append("\n");
        sb.append("    executionsLimit: ").append(toIndentedString(executionsLimit)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    disableHttpGet: ").append(toIndentedString(disableHttpGet)).append("\n");
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
