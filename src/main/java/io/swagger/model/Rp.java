package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * The “relying party” responsible for registering and authenticating the user
 */
@ApiModel(description = "The “relying party” responsible for registering and authenticating the user")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class Rp {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("name")
    private String name = null;

    public Rp id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id must be a subset of the RP's domain
     *
     * @return id
     **/
    @ApiModelProperty(example = "matrarc.com", value = "The id must be a subset of the RP's domain")

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rp name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(example = "Metrarc Ltd.", value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rp rp = (Rp) o;
        return Objects.equals(this.id, rp.id) &&
                Objects.equals(this.name, rp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Rp {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
