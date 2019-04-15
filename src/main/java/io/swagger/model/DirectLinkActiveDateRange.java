package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * DirectLinkActiveDateRange
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class DirectLinkActiveDateRange {
    @JsonProperty("dateStart")
    private OffsetDateTime dateStart = null;

    @JsonProperty("dateEnd")
    private OffsetDateTime dateEnd = null;

    public DirectLinkActiveDateRange dateStart(OffsetDateTime dateStart) {
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

    public DirectLinkActiveDateRange dateEnd(OffsetDateTime dateEnd) {
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectLinkActiveDateRange directLinkActiveDateRange = (DirectLinkActiveDateRange) o;
        return Objects.equals(this.dateStart, directLinkActiveDateRange.dateStart) &&
                       Objects.equals(this.dateEnd, directLinkActiveDateRange.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectLinkActiveDateRange {\n");

        sb.append("    dateStart: ").append(toIndentedString(dateStart)).append("\n");
        sb.append("    dateEnd: ").append(toIndentedString(dateEnd)).append("\n");
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
