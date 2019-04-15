package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ChannelUpdateConfirmationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ChannelUpdateConfirmationResponse {
    @JsonProperty("schedules")
    @Valid
    private List<Schedule> schedules = null;

    @JsonProperty("groups")
    @Valid
    private List<ChannelGroup> groups = null;

    public ChannelUpdateConfirmationResponse schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public ChannelUpdateConfirmationResponse addSchedulesItem(Schedule schedulesItem) {
        if (this.schedules == null) {
            this.schedules = new ArrayList<Schedule>();
        }
        this.schedules.add(schedulesItem);
        return this;
    }

    /**
     * Schedules that will be deleted after this request.
     *
     * @return schedules
     **/
    @ApiModelProperty(value = "Schedules that will be deleted after this request.")
    @Valid
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public ChannelUpdateConfirmationResponse groups(List<ChannelGroup> groups) {
        this.groups = groups;
        return this;
    }

    public ChannelUpdateConfirmationResponse addGroupsItem(ChannelGroup groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<ChannelGroup>();
        }
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * Channel groups that this channel will be removed from after this request.
     *
     * @return groups
     **/
    @ApiModelProperty(value = "Channel groups that this channel will be removed from after this request.")
    @Valid
    public List<ChannelGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ChannelGroup> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelUpdateConfirmationResponse channelUpdateConfirmationResponse = (ChannelUpdateConfirmationResponse) o;
        return Objects.equals(this.schedules, channelUpdateConfirmationResponse.schedules) &&
                       Objects.equals(this.groups, channelUpdateConfirmationResponse.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedules, groups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelUpdateConfirmationResponse {\n");

        sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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
