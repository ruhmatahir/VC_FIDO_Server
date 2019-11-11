package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * AuthenticatorSelection
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class AuthenticatorSelection {
    @JsonProperty("requireResidentKey")
    private Boolean requireResidentKey = null;

    @JsonProperty("userVerification")
    private UserVerification userVerification = null;

    public AuthenticatorSelection requireResidentKey(Boolean requireResidentKey) {
        this.requireResidentKey = requireResidentKey;
        return this;
    }

    /**
     * Get requireResidentKey
     *
     * @return requireResidentKey
     **/
    @ApiModelProperty(value = "")

    public Boolean isRequireResidentKey() {
        return requireResidentKey;
    }

    public void setRequireResidentKey(Boolean requireResidentKey) {
        this.requireResidentKey = requireResidentKey;
    }

    public AuthenticatorSelection userVerification(UserVerification userVerification) {
        this.userVerification = userVerification;
        return this;
    }

    /**
     * Get userVerification
     *
     * @return userVerification
     **/
    @ApiModelProperty(value = "")

    @Valid
    public UserVerification getUserVerification() {
        return userVerification;
    }

    public void setUserVerification(UserVerification userVerification) {
        this.userVerification = userVerification;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticatorSelection authenticatorSelection = (AuthenticatorSelection) o;
        return Objects.equals(this.requireResidentKey, authenticatorSelection.requireResidentKey) &&
                Objects.equals(this.userVerification, authenticatorSelection.userVerification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requireResidentKey, userVerification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticatorSelection {\n");

        sb.append("    requireResidentKey: ").append(toIndentedString(requireResidentKey)).append("\n");
        sb.append("    userVerification: ").append(toIndentedString(userVerification)).append("\n");
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
