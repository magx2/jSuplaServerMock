package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserIcon
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
public class UserIcon {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("images")
    @Valid
    private List<String> images = null;

    public UserIcon id(Integer id) {
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

    public UserIcon images(List<String> images) {
        this.images = images;
        return this;
    }

    public UserIcon addImagesItem(String imagesItem) {
        if (this.images == null) {
            this.images = new ArrayList<String>();
        }
        this.images.add(imagesItem);
        return this;
    }

    /**
     * Returned only if requested by the `include` parameter. Array contains images blobs encoded with Base64.
     *
     * @return images
     **/
    @ApiModelProperty(value = "Returned only if requested by the `include` parameter. Array contains images blobs encoded with Base64.")

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserIcon userIcon = (UserIcon) o;
        return Objects.equals(this.id, userIcon.id) &&
                       Objects.equals(this.images, userIcon.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, images);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserIcon {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    images: ").append(toIndentedString(images)).append("\n");
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
