package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AuthenticatorAssertionResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class AuthenticatorAssertionResponse {
    @JsonProperty("id")
    private byte[] id = null;

    @JsonProperty("rawId")
    private byte[] rawId = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("response")
    private AuthenticatorAssertionResponseResponse response = null;

    public AuthenticatorAssertionResponse id(byte[] id) {
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

    public AuthenticatorAssertionResponse rawId(byte[] rawId) {
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

    public AuthenticatorAssertionResponse type(String type) {
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

    public AuthenticatorAssertionResponse response(AuthenticatorAssertionResponseResponse response) {
        this.response = response;
        return this;
    }

    /**
     * Get response
     *
     * @return response
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public AuthenticatorAssertionResponseResponse getResponse() {
        return response;
    }

    public void setResponse(AuthenticatorAssertionResponseResponse response) {
        this.response = response;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) o;
        return Objects.equals(this.id, authenticatorAssertionResponse.id) &&
                Objects.equals(this.rawId, authenticatorAssertionResponse.rawId) &&
                Objects.equals(this.type, authenticatorAssertionResponse.type) &&
                Objects.equals(this.response, authenticatorAssertionResponse.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rawId, type, response);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticatorAssertionResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rawId: ").append(toIndentedString(rawId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
