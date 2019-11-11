package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ExcludeCredentialsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class ExcludeCredentialsInner {
    @JsonProperty("PublicKeyCredentialType")
    private Integer publicKeyCredentialType = null;

    @JsonProperty("credentialId")
    private byte[] credentialId = null;

    public ExcludeCredentialsInner publicKeyCredentialType(Integer publicKeyCredentialType) {
        this.publicKeyCredentialType = publicKeyCredentialType;
        return this;
    }

    /**
     * Get publicKeyCredentialType
     *
     * @return publicKeyCredentialType
     **/
    @ApiModelProperty(value = "")

    public Integer getPublicKeyCredentialType() {
        return publicKeyCredentialType;
    }

    public void setPublicKeyCredentialType(Integer publicKeyCredentialType) {
        this.publicKeyCredentialType = publicKeyCredentialType;
    }

    public ExcludeCredentialsInner credentialId(byte[] credentialId) {
        this.credentialId = credentialId;
        return this;
    }

    /**
     * Get credentialId
     *
     * @return credentialId
     **/
    @ApiModelProperty(value = "")

    public byte[] getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(byte[] credentialId) {
        this.credentialId = credentialId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExcludeCredentialsInner excludeCredentialsInner = (ExcludeCredentialsInner) o;
        return Objects.equals(this.publicKeyCredentialType, excludeCredentialsInner.publicKeyCredentialType) &&
                Objects.equals(this.credentialId, excludeCredentialsInner.credentialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicKeyCredentialType, credentialId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExcludeCredentialsInner {\n");

        sb.append("    publicKeyCredentialType: ").append(toIndentedString(publicKeyCredentialType)).append("\n");
        sb.append("    credentialId: ").append(toIndentedString(credentialId)).append("\n");
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
