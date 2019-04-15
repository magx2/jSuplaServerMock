package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * SchedulePast
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class SchedulePast {
    @JsonProperty("plannedTimestamp")
    private OffsetDateTime plannedTimestamp = null;

    @JsonProperty("resultTimestamp")
    private OffsetDateTime resultTimestamp = null;

    @JsonProperty("failed")
    private Boolean failed = null;

    @JsonProperty("result")
    private ScheduleResult result = null;

    public SchedulePast plannedTimestamp(OffsetDateTime plannedTimestamp) {
        this.plannedTimestamp = plannedTimestamp;
        return this;
    }

    /**
     * Get plannedTimestamp
     *
     * @return plannedTimestamp
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getPlannedTimestamp() {
        return plannedTimestamp;
    }

    public void setPlannedTimestamp(OffsetDateTime plannedTimestamp) {
        this.plannedTimestamp = plannedTimestamp;
    }

    public SchedulePast resultTimestamp(OffsetDateTime resultTimestamp) {
        this.resultTimestamp = resultTimestamp;
        return this;
    }

    /**
     * Get resultTimestamp
     *
     * @return resultTimestamp
     **/
    @ApiModelProperty(value = "")

    @Valid
    public OffsetDateTime getResultTimestamp() {
        return resultTimestamp;
    }

    public void setResultTimestamp(OffsetDateTime resultTimestamp) {
        this.resultTimestamp = resultTimestamp;
    }

    public SchedulePast failed(Boolean failed) {
        this.failed = failed;
        return this;
    }

    /**
     * Get failed
     *
     * @return failed
     **/
    @ApiModelProperty(example = "false", value = "")

    public Boolean isFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public SchedulePast result(ScheduleResult result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     *
     * @return result
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ScheduleResult getResult() {
        return result;
    }

    public void setResult(ScheduleResult result) {
        this.result = result;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchedulePast schedulePast = (SchedulePast) o;
        return Objects.equals(this.plannedTimestamp, schedulePast.plannedTimestamp) &&
                       Objects.equals(this.resultTimestamp, schedulePast.resultTimestamp) &&
                       Objects.equals(this.failed, schedulePast.failed) &&
                       Objects.equals(this.result, schedulePast.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plannedTimestamp, resultTimestamp, failed, result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SchedulePast {\n");

        sb.append("    plannedTimestamp: ").append(toIndentedString(plannedTimestamp)).append("\n");
        sb.append("    resultTimestamp: ").append(toIndentedString(resultTimestamp)).append("\n");
        sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
