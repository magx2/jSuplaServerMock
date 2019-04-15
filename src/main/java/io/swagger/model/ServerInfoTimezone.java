package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ServerInfoTimezone
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class ServerInfoTimezone {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("offset")
    private Integer offset = null;

    public ServerInfoTimezone name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(example = "UTC", value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServerInfoTimezone offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Timezone offset in minutes
     *
     * @return offset
     **/
    @ApiModelProperty(value = "Timezone offset in minutes")

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerInfoTimezone serverInfoTimezone = (ServerInfoTimezone) o;
        return Objects.equals(this.name, serverInfoTimezone.name) &&
                       Objects.equals(this.offset, serverInfoTimezone.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, offset);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServerInfoTimezone {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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
