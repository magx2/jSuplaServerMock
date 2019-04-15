package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ScheduleFuture
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ScheduleFuture {
    @JsonProperty("plannedTimestamp")
    private OffsetDateTime plannedTimestamp = null;

    public ScheduleFuture plannedTimestamp(OffsetDateTime plannedTimestamp) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScheduleFuture scheduleFuture = (ScheduleFuture) o;
        return Objects.equals(this.plannedTimestamp, scheduleFuture.plannedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plannedTimestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleFuture {\n");

        sb.append("    plannedTimestamp: ").append(toIndentedString(plannedTimestamp)).append("\n");
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
