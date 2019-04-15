package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Schedule
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class Schedule {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("timeExpression")
    private String timeExpression = null;

    @JsonProperty("action")
    private ChannelFunctionAction action = null;

    @JsonProperty("actionParam")
    private Object actionParam = null;

    /**
     * Gets or Sets mode
     */
    public enum ModeEnum {
        MINUTELY("minutely"),

        HOURLY("hourly"),

        DAILY("daily"),

        ONCE("once");

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

    @JsonProperty("dateStart")
    private OffsetDateTime dateStart = null;

    @JsonProperty("dateEnd")
    private OffsetDateTime dateEnd = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("caption")
    private String caption = null;

    @JsonProperty("retry")
    private Boolean retry = null;

    @JsonProperty("channelId")
    private Integer channelId = null;

    @JsonProperty("actionId")
    private Integer actionId = null;

    @JsonProperty("channel")
    private Channel channel = null;

    @JsonProperty("closestExecutions")
    @Valid
    private List<ScheduleClosestExecutions> closestExecutions = null;

    public Schedule id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Schedule identifier
     *
     * @return id
     **/
    @ApiModelProperty(value = "Schedule identifier")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Schedule timeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
        return this;
    }

    /**
     * Schedule time expression in crontab notation (with some custom additions).
     *
     * @return timeExpression
     **/
    @ApiModelProperty(example = "*_/5 * * * *", value = "Schedule time expression in crontab notation (with some custom additions).")

    public String getTimeExpression() {
        return timeExpression;
    }

    public void setTimeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
    }

    public Schedule action(ChannelFunctionAction action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ChannelFunctionAction getAction() {
        return action;
    }

    public void setAction(ChannelFunctionAction action) {
        this.action = action;
    }

    public Schedule actionParam(Object actionParam) {
        this.actionParam = actionParam;
        return this;
    }

    /**
     * Depends on the action.
     *
     * @return actionParam
     **/
    @ApiModelProperty(example = "{}", value = "Depends on the action.")

    public Object getActionParam() {
        return actionParam;
    }

    public void setActionParam(Object actionParam) {
        this.actionParam = actionParam;
    }

    public Schedule mode(ModeEnum mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Get mode
     *
     * @return mode
     **/
    @ApiModelProperty(value = "")

    public ModeEnum getMode() {
        return mode;
    }

    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    public Schedule dateStart(OffsetDateTime dateStart) {
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

    public Schedule dateEnd(OffsetDateTime dateEnd) {
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

    public Schedule enabled(Boolean enabled) {
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

    public Schedule caption(String caption) {
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

    public Schedule retry(Boolean retry) {
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

    public Schedule channelId(Integer channelId) {
        this.channelId = channelId;
        return this;
    }

    /**
     * Get channelId
     *
     * @return channelId
     **/
    @ApiModelProperty(value = "")

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Schedule actionId(Integer actionId) {
        this.actionId = actionId;
        return this;
    }

    /**
     * Get actionId
     *
     * @return actionId
     **/
    @ApiModelProperty(value = "")

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Schedule channel(Channel channel) {
        this.channel = channel;
        return this;
    }

    /**
     * Get channel
     *
     * @return channel
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Schedule closestExecutions(List<ScheduleClosestExecutions> closestExecutions) {
        this.closestExecutions = closestExecutions;
        return this;
    }

    public Schedule addClosestExecutionsItem(ScheduleClosestExecutions closestExecutionsItem) {
        if (this.closestExecutions == null) {
            this.closestExecutions = new ArrayList<ScheduleClosestExecutions>();
        }
        this.closestExecutions.add(closestExecutionsItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter. Contains two arrays of maximum 3 closest past and future executions.
     *
     * @return closestExecutions
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter. Contains two arrays of maximum 3 closest past and future executions.")
    @Valid
    public List<ScheduleClosestExecutions> getClosestExecutions() {
        return closestExecutions;
    }

    public void setClosestExecutions(List<ScheduleClosestExecutions> closestExecutions) {
        this.closestExecutions = closestExecutions;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Schedule schedule = (Schedule) o;
        return Objects.equals(this.id, schedule.id) &&
                       Objects.equals(this.timeExpression, schedule.timeExpression) &&
                       Objects.equals(this.action, schedule.action) &&
                       Objects.equals(this.actionParam, schedule.actionParam) &&
                       Objects.equals(this.mode, schedule.mode) &&
                       Objects.equals(this.dateStart, schedule.dateStart) &&
                       Objects.equals(this.dateEnd, schedule.dateEnd) &&
                       Objects.equals(this.enabled, schedule.enabled) &&
                       Objects.equals(this.caption, schedule.caption) &&
                       Objects.equals(this.retry, schedule.retry) &&
                       Objects.equals(this.channelId, schedule.channelId) &&
                       Objects.equals(this.actionId, schedule.actionId) &&
                       Objects.equals(this.channel, schedule.channel) &&
                       Objects.equals(this.closestExecutions, schedule.closestExecutions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeExpression, action, actionParam, mode, dateStart, dateEnd, enabled, caption, retry, channelId, actionId, channel, closestExecutions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Schedule {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    timeExpression: ").append(toIndentedString(timeExpression)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    actionParam: ").append(toIndentedString(actionParam)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    dateStart: ").append(toIndentedString(dateStart)).append("\n");
        sb.append("    dateEnd: ").append(toIndentedString(dateEnd)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
        sb.append("    retry: ").append(toIndentedString(retry)).append("\n");
        sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
        sb.append("    actionId: ").append(toIndentedString(actionId)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    closestExecutions: ").append(toIndentedString(closestExecutions)).append("\n");
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
