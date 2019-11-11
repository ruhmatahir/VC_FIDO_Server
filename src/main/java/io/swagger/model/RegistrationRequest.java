package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Information about the user wanting to register with the server
 */
@ApiModel(description = "Information about the user wanting to register with the server")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class RegistrationRequest {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("displayname")
    private String displayname = null;

    public RegistrationRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(example = "ruhma@metrarc.com", value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegistrationRequest displayname(String displayname) {
        this.displayname = displayname;
        return this;
    }

    /**
     * Get displayname
     *
     * @return displayname
     **/
    @ApiModelProperty(example = "Ruhma Tahir", value = "")

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegistrationRequest registrationRequest = (RegistrationRequest) o;
        return Objects.equals(this.name, registrationRequest.name) &&
                Objects.equals(this.displayname, registrationRequest.displayname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayname);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegistrationRequest {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayname: ").append(toIndentedString(displayname)).append("\n");
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
