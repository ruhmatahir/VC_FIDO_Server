package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AuthenticatorAttestationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class AuthenticatorAttestationResponse {
    @JsonProperty("id")
    private byte[] id = null;

    @JsonProperty("rawId")
    private byte[] rawId = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("clientDataJSON")
    private byte[] clientDataJSON = null;

    @JsonProperty("attestationObject")
    private AttestationObject attestationObject = null;

    public AuthenticatorAttestationResponse id(byte[] id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public byte[] getId() {
        return id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }

    public AuthenticatorAttestationResponse rawId(byte[] rawId) {
        this.rawId = rawId;
        return this;
    }

    /**
     * Get rawId
     *
     * @return rawId
     **/
    @ApiModelProperty(value = "")

    public byte[] getRawId() {
        return rawId;
    }

    public void setRawId(byte[] rawId) {
        this.rawId = rawId;
    }

    public AuthenticatorAttestationResponse type(String type) {
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

    public AuthenticatorAttestationResponse clientDataJSON(byte[] clientDataJSON) {
        this.clientDataJSON = clientDataJSON;
        return this;
    }

    /**
     * Get clientDataJSON
     *
     * @return clientDataJSON
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public byte[] getClientDataJSON() {
        return clientDataJSON;
    }

    public void setClientDataJSON(byte[] clientDataJSON) {
        this.clientDataJSON = clientDataJSON;
    }

    public AuthenticatorAttestationResponse attestationObject(AttestationObject attestationObject) {
        this.attestationObject = attestationObject;
        return this;
    }

    /**
     * Get attestationObject
     *
     * @return attestationObject
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public AttestationObject getAttestationObject() {
        return attestationObject;
    }

    public void setAttestationObject(AttestationObject attestationObject) {
        this.attestationObject = attestationObject;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) o;
        return Objects.equals(this.id, authenticatorAttestationResponse.id) &&
                Objects.equals(this.rawId, authenticatorAttestationResponse.rawId) &&
                Objects.equals(this.type, authenticatorAttestationResponse.type) &&
                Objects.equals(this.clientDataJSON, authenticatorAttestationResponse.clientDataJSON) &&
                Objects.equals(this.attestationObject, authenticatorAttestationResponse.attestationObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rawId, type, clientDataJSON, attestationObject);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticatorAttestationResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rawId: ").append(toIndentedString(rawId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    clientDataJSON: ").append(toIndentedString(clientDataJSON)).append("\n");
        sb.append("    attestationObject: ").append(toIndentedString(attestationObject)).append("\n");
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
