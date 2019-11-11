package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AuthenticatorAssertionResponseResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class AuthenticatorAssertionResponseResponse {
    @JsonProperty("authenticatorData")
    private byte[] authenticatorData = null;

    @JsonProperty("clientDataJSON")
    private byte[] clientDataJSON = null;

    @JsonProperty("signature")
    private byte[] signature = null;

    @JsonProperty("userHandle")
    private byte[] userHandle = null;

    public AuthenticatorAssertionResponseResponse authenticatorData(byte[] authenticatorData) {
        this.authenticatorData = authenticatorData;
        return this;
    }

    /**
     * Get authenticatorData
     *
     * @return authenticatorData
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public byte[] getAuthenticatorData() {
        return authenticatorData;
    }

    public void setAuthenticatorData(byte[] authenticatorData) {
        this.authenticatorData = authenticatorData;
    }

    public AuthenticatorAssertionResponseResponse clientDataJSON(byte[] clientDataJSON) {
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

    public AuthenticatorAssertionResponseResponse signature(byte[] signature) {
        this.signature = signature;
        return this;
    }

    /**
     * Get signature
     *
     * @return signature
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public AuthenticatorAssertionResponseResponse userHandle(byte[] userHandle) {
        this.userHandle = userHandle;
        return this;
    }

    /**
     * Get userHandle
     *
     * @return userHandle
     **/
    @ApiModelProperty(value = "")

    public byte[] getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(byte[] userHandle) {
        this.userHandle = userHandle;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticatorAssertionResponseResponse authenticatorAssertionResponseResponse = (AuthenticatorAssertionResponseResponse) o;
        return Objects.equals(this.authenticatorData, authenticatorAssertionResponseResponse.authenticatorData) &&
                Objects.equals(this.clientDataJSON, authenticatorAssertionResponseResponse.clientDataJSON) &&
                Objects.equals(this.signature, authenticatorAssertionResponseResponse.signature) &&
                Objects.equals(this.userHandle, authenticatorAssertionResponseResponse.userHandle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticatorData, clientDataJSON, signature, userHandle);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticatorAssertionResponseResponse {\n");

        sb.append("    authenticatorData: ").append(toIndentedString(authenticatorData)).append("\n");
        sb.append("    clientDataJSON: ").append(toIndentedString(clientDataJSON)).append("\n");
        sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
        sb.append("    userHandle: ").append(toIndentedString(userHandle)).append("\n");
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
