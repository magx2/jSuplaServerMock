package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.File;
import java.util.Objects;

/**
 * Multipart request with files to save as a new icon. The number of images required to be sent with the request is determined by the chosen function identifier (it must match the &#x60;function.possibleVisualStates&#x60; count). Each image represents the respective visual state from &#x60;function.possibleVisualStates&#x60; array.
 */
@ApiModel(description = "Multipart request with files to save as a new icon. The number of images required to be sent with the request is determined by the chosen function identifier (it must match the `function.possibleVisualStates` count). Each image represents the respective visual state from `function.possibleVisualStates` array.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class Body {
    @JsonProperty("function")
    private ChannelFunctionEnumNames function = null;

    @JsonProperty("sourceIcon")
    private Integer sourceIcon = null;

    @JsonProperty("image1")
    private File image1 = null;

    @JsonProperty("image2")
    private File image2 = null;

    @JsonProperty("image3")
    private File image3 = null;

    @JsonProperty("image4")
    private File image4 = null;

    public Body function(ChannelFunctionEnumNames function) {
        this.function = function;
        return this;
    }

    /**
     * Get function
     *
     * @return function
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ChannelFunctionEnumNames getFunction() {
        return function;
    }

    public void setFunction(ChannelFunctionEnumNames function) {
        this.function = function;
    }

    public Body sourceIcon(Integer sourceIcon) {
        this.sourceIcon = sourceIcon;
        return this;
    }

    /**
     * ID of an existing user icon to replace with these new files. Optional.
     *
     * @return sourceIcon
     **/
    @ApiModelProperty(value = "ID of an existing user icon to replace with these new files. Optional.")

    public Integer getSourceIcon() {
        return sourceIcon;
    }

    public void setSourceIcon(Integer sourceIcon) {
        this.sourceIcon = sourceIcon;
    }

    public Body image1(File image1) {
        this.image1 = image1;
        return this;
    }

    /**
     * Get image1
     *
     * @return image1
     **/
    @ApiModelProperty(value = "")

    @Valid
    public File getImage1() {
        return image1;
    }

    public void setImage1(File image1) {
        this.image1 = image1;
    }

    public Body image2(File image2) {
        this.image2 = image2;
        return this;
    }

    /**
     * Get image2
     *
     * @return image2
     **/
    @ApiModelProperty(value = "")

    @Valid
    public File getImage2() {
        return image2;
    }

    public void setImage2(File image2) {
        this.image2 = image2;
    }

    public Body image3(File image3) {
        this.image3 = image3;
        return this;
    }

    /**
     * Get image3
     *
     * @return image3
     **/
    @ApiModelProperty(value = "")

    @Valid
    public File getImage3() {
        return image3;
    }

    public void setImage3(File image3) {
        this.image3 = image3;
    }

    public Body image4(File image4) {
        this.image4 = image4;
        return this;
    }

    /**
     * Get image4
     *
     * @return image4
     **/
    @ApiModelProperty(value = "")

    @Valid
    public File getImage4() {
        return image4;
    }

    public void setImage4(File image4) {
        this.image4 = image4;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Body body = (Body) o;
        return Objects.equals(this.function, body.function) &&
                       Objects.equals(this.sourceIcon, body.sourceIcon) &&
                       Objects.equals(this.image1, body.image1) &&
                       Objects.equals(this.image2, body.image2) &&
                       Objects.equals(this.image3, body.image3) &&
                       Objects.equals(this.image4, body.image4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function, sourceIcon, image1, image2, image3, image4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Body {\n");

        sb.append("    function: ").append(toIndentedString(function)).append("\n");
        sb.append("    sourceIcon: ").append(toIndentedString(sourceIcon)).append("\n");
        sb.append("    image1: ").append(toIndentedString(image1)).append("\n");
        sb.append("    image2: ").append(toIndentedString(image2)).append("\n");
        sb.append("    image3: ").append(toIndentedString(image3)).append("\n");
        sb.append("    image4: ").append(toIndentedString(image4)).append("\n");
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
