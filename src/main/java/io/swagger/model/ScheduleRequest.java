package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ScheduleRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ScheduleRequest {
    @JsonProperty("channelId")
    private Integer channelId = null;

    @JsonProperty("actionId")
    private Integer actionId = null;

    /**
     * Gets or Sets mode
     */
    public enum ModeEnum {
        ONCE("once"),

        MINUTELY("minutely"),

        DAILY("daily"),

        HOURLY("hourly");

        private String value;

        ModeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ModeEnum fromValue(String text) {
            for (ModeEnum b : ModeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("mode")
    private ModeEnum mode = null;

    @JsonProperty("timeExpression")
    private String timeExpression = null;

    @JsonProperty("actionParam")
    private Object actionParam = null;

    @JsonProperty("dateStart")
    private OffsetDateTime dateStart = null;

    @JsonProperty("dateEnd")
    private OffsetDateTime dateEnd = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("retry")
    private Boolean retry = null;

    public ScheduleRequest channelId(Integer channelId) {
        this.channelId = channelId;
        return this;
    }

    /**
     * Get channelId
     *
     * @return channelId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public ScheduleRequest actionId(Integer actionId) {
        this.actionId = actionId;
        return this;
    }

    /**
     * Get actionId
     *
     * @return actionId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public ScheduleRequest mode(ModeEnum mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Get mode
     *
     * @return mode
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public ModeEnum getMode() {
        return mode;
    }

    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    public ScheduleRequest timeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
        return this;
    }

    /**
     * Schedule time expression in crontab notation (with some custom additions).
     *
     * @return timeExpression
     **/
    @ApiModelProperty(required = true, value = "Schedule time expression in crontab notation (with some custom additions).")
    @NotNull

    public String getTimeExpression() {
        return timeExpression;
    }

    public void setTimeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
    }

    public ScheduleRequest actionParam(Object actionParam) {
        this.actionParam = actionParam;
        return this;
    }

    /**
     * Get actionParam
     *
     * @return actionParam
     **/
    @ApiModelProperty(example = "{}", value = "")

    public Object getActionParam() {
        return actionParam;
    }

    public void setActionParam(Object actionParam) {
        this.actionParam = actionParam;
    }

    public ScheduleRequest dateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    /**
     * Get dateStart
     *
     * @return dateStart
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(OffsetDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public ScheduleRequest dateEnd(OffsetDateTime dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    /**
     * Get dateEnd
     *
     * @return dateEnd
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(OffsetDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ScheduleRequest caption(String caption) {
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

    public ScheduleRequest retry(Boolean retry) {
        this.retry = retry;
        return this;
    }

    /**
     * Get retry
     *
     * @return retry
     **/
    @ApiModelProperty(value = "")

    public Boolean isRetry() {
        return retry;
    }

    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScheduleRequest scheduleRequest = (ScheduleRequest) o;
        return Objects.equals(this.channelId, scheduleRequest.channelId) &&
                       Objects.equals(this.actionId, scheduleRequest.actionId) &&
                       Objects.equals(this.mode, scheduleRequest.mode) &&
                       Objects.equals(this.timeExpression, scheduleRequest.timeExpression) &&
                       Objects.equals(this.actionParam, scheduleRequest.actionParam) &&
                       Objects.equals(this.dateStart, scheduleRequest.dateStart) &&
                       Objects.equals(this.dateEnd, scheduleRequest.dateEnd) &&
                       Objects.equals(this.caption, scheduleRequest.caption) &&
                       Objects.equals(this.retry, scheduleRequest.retry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, actionId, mode, timeExpression, actionParam, dateStart, dateEnd, caption, retry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleRequest {\n");

        sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
        sb.append("    actionId: ").append(toIndentedString(actionId)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    timeExpression: ").append(toIndentedString(timeExpression)).append("\n");
        sb.append("    actionParam: ").append(toIndentedString(actionParam)).append("\n");
        sb.append("    dateStart: ").append(toIndentedString(dateStart)).append("\n");
        sb.append("    dateEnd: ").append(toIndentedString(dateEnd)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    retry: ").append(toIndentedString(retry)).append("\n");
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
