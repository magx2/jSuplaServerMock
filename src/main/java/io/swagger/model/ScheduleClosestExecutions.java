package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ScheduleClosestExecutions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ScheduleClosestExecutions {
    @JsonProperty("past")
    @Valid
    private List<SchedulePast> past = null;

    @JsonProperty("future")
    @Valid
    private List<ScheduleFuture> future = null;

    public ScheduleClosestExecutions past(List<SchedulePast> past) {
        this.past = past;
        return this;
    }

    public ScheduleClosestExecutions addPastItem(SchedulePast pastItem) {
        if (this.past == null) {
            this.past = new ArrayList<SchedulePast>();
        }
        this.past.add(pastItem);
        return this;
    }

    /**
     * Get past
     *
     * @return past
     **/
    @ApiModelProperty(value = "")
    @Valid
    public List<SchedulePast> getPast() {
        return past;
    }

    public void setPast(List<SchedulePast> past) {
        this.past = past;
    }

    public ScheduleClosestExecutions future(List<ScheduleFuture> future) {
        this.future = future;
        return this;
    }

    public ScheduleClosestExecutions addFutureItem(ScheduleFuture futureItem) {
        if (this.future == null) {
            this.future = new ArrayList<ScheduleFuture>();
        }
        this.future.add(futureItem);
        return this;
    }

    /**
     * Get future
     *
     * @return future
     **/
    @ApiModelProperty(value = "")
    @Valid
    public List<ScheduleFuture> getFuture() {
        return future;
    }

    public void setFuture(List<ScheduleFuture> future) {
        this.future = future;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScheduleClosestExecutions scheduleClosestExecutions = (ScheduleClosestExecutions) o;
        return Objects.equals(this.past, scheduleClosestExecutions.past) &&
                       Objects.equals(this.future, scheduleClosestExecutions.future);
    }

    @Override
    public int hashCode() {
        return Objects.hash(past, future);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleClosestExecutions {\n");

        sb.append("    past: ").append(toIndentedString(past)).append("\n");
        sb.append("    future: ").append(toIndentedString(future)).append("\n");
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
