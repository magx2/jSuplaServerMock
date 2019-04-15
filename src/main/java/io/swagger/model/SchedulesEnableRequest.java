package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SchedulesEnableRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class SchedulesEnableRequest {
    @JsonProperty("enable")
    @Valid
    private List<Integer> enable = null;

    public SchedulesEnableRequest enable(List<Integer> enable) {
        this.enable = enable;
        return this;
    }

    public SchedulesEnableRequest addEnableItem(Integer enableItem) {
        if (this.enable == null) {
            this.enable = new ArrayList<Integer>();
        }
        this.enable.add(enableItem);
        return this;
    }

    /**
     * Array of schedule identifiers to enable
     *
     * @return enable
     **/
    @ApiModelProperty(value = "Array of schedule identifiers to enable")

    public List<Integer> getEnable() {
        return enable;
    }

    public void setEnable(List<Integer> enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchedulesEnableRequest schedulesEnableRequest = (SchedulesEnableRequest) o;
        return Objects.equals(this.enable, schedulesEnableRequest.enable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SchedulesEnableRequest {\n");

        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
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
