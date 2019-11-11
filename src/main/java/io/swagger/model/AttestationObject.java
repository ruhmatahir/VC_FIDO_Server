package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * This object contains the credential public key, the attestation certificate, and other metadata used be server to verify the registration event.
 */
@ApiModel(description = "This object contains the credential public key, the attestation certificate, and other metadata used be server to verify the registration event. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class AttestationObject {
    @JsonProperty("authenticatorData")
    private byte[] authenticatorData = null;

    @JsonProperty("attestationStatement")
    private byte[] attestationStatement = null;

    public AttestationObject authenticatorData(byte[] authenticatorData) {
        this.authenticatorData = authenticatorData;
        return this;
    }

    /**
     * Get authenticatorData
     *
     * @return authenticatorData
     **/
    @ApiModelProperty(value = "")

    public byte[] getAuthenticatorData() {
        return authenticatorData;
    }

    public void setAuthenticatorData(byte[] authenticatorData) {
        this.authenticatorData = authenticatorData;
    }

    public AttestationObject attestationStatement(byte[] attestationStatement) {
        this.attestationStatement = attestationStatement;
        return this;
    }

    /**
     * Get attestationStatement
     *
     * @return attestationStatement
     **/
    @ApiModelProperty(value = "")

    public byte[] getAttestationStatement() {
        return attestationStatement;
    }

    public void setAttestationStatement(byte[] attestationStatement) {
        this.attestationStatement = attestationStatement;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttestationObject attestationObject = (AttestationObject) o;
        return Objects.equals(this.authenticatorData, attestationObject.authenticatorData) &&
                Objects.equals(this.attestationStatement, attestationObject.attestationStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticatorData, attestationStatement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AttestationObject {\n");

        sb.append("    authenticatorData: ").append(toIndentedString(authenticatorData)).append("\n");
        sb.append("    attestationStatement: ").append(toIndentedString(attestationStatement)).append("\n");
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
