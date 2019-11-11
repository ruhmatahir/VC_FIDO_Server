package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * PublicKeyCredParamsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class PublicKeyCredParamsInner {
    @JsonProperty("alg")
    private Integer alg = null;

    @JsonProperty("type")
    private String type = null;

    public PublicKeyCredParamsInner alg(Integer alg) {
        this.alg = alg;
        return this;
    }

    /**
     * Get alg
     *
     * @return alg
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Integer getAlg() {
        return alg;
    }

    public void setAlg(Integer alg) {
        this.alg = alg;
    }

    public PublicKeyCredParamsInner type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(example = "public-key", required = true, value = "")
    @NotNull

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublicKeyCredParamsInner publicKeyCredParamsInner = (PublicKeyCredParamsInner) o;
        return Objects.equals(this.alg, publicKeyCredParamsInner.alg) &&
                Objects.equals(this.type, publicKeyCredParamsInner.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alg, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublicKeyCredParamsInner {\n");

        sb.append("    alg: ").append(toIndentedString(alg)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
