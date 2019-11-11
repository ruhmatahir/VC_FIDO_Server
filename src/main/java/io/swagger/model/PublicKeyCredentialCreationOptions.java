package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * PublicKeyCredentialCreationOptions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class PublicKeyCredentialCreationOptions {
    @JsonProperty("rp")
    private Rp rp = null;

    @JsonProperty("user")
    private User user = null;

    @JsonProperty("challenge")
    private byte[] challenge = null;

    @JsonProperty("pubKeyCredParams")
    private PubKeyCredParams pubKeyCredParams = null;

    @JsonProperty("timeout")
    private Integer timeout = null;

    @JsonProperty("excludeCredentials")
    private ExcludeCredentials excludeCredentials = null;

    @JsonProperty("authenticatorSelection")
    private AuthenticatorSelection authenticatorSelection = null;

    @JsonProperty("attestation")
    private Attestation attestation = null;

    @JsonProperty("extensions")
    private Extensions extensions = null;

    public PublicKeyCredentialCreationOptions rp(Rp rp) {
        this.rp = rp;
        return this;
    }

    /**
     * Get rp
     *
     * @return rp
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public Rp getRp() {
        return rp;
    }

    public void setRp(Rp rp) {
        this.rp = rp;
    }

    public PublicKeyCredentialCreationOptions user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PublicKeyCredentialCreationOptions challenge(byte[] challenge) {
        this.challenge = challenge;
        return this;
    }

    /**
     * Get challenge
     *
     * @return challenge
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Size(min = 16)
    public byte[] getChallenge() {
        return challenge;
    }

    public void setChallenge(byte[] challenge) {
        this.challenge = challenge;
    }

    public PublicKeyCredentialCreationOptions pubKeyCredParams(PubKeyCredParams pubKeyCredParams) {
        this.pubKeyCredParams = pubKeyCredParams;
        return this;
    }

    /**
     * Get pubKeyCredParams
     *
     * @return pubKeyCredParams
     **/
    @ApiModelProperty(value = "")

    @Valid
    public PubKeyCredParams getPubKeyCredParams() {
        return pubKeyCredParams;
    }

    public void setPubKeyCredParams(PubKeyCredParams pubKeyCredParams) {
        this.pubKeyCredParams = pubKeyCredParams;
    }

    public PublicKeyCredentialCreationOptions timeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Get timeout
     *
     * @return timeout
     **/
    @ApiModelProperty(value = "")

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public PublicKeyCredentialCreationOptions excludeCredentials(ExcludeCredentials excludeCredentials) {
        this.excludeCredentials = excludeCredentials;
        return this;
    }

    /**
     * Get excludeCredentials
     *
     * @return excludeCredentials
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ExcludeCredentials getExcludeCredentials() {
        return excludeCredentials;
    }

    public void setExcludeCredentials(ExcludeCredentials excludeCredentials) {
        this.excludeCredentials = excludeCredentials;
    }

    public PublicKeyCredentialCreationOptions authenticatorSelection(AuthenticatorSelection authenticatorSelection) {
        this.authenticatorSelection = authenticatorSelection;
        return this;
    }

    /**
     * Get authenticatorSelection
     *
     * @return authenticatorSelection
     **/
    @ApiModelProperty(value = "")

    @Valid
    public AuthenticatorSelection getAuthenticatorSelection() {
        return authenticatorSelection;
    }

    public void setAuthenticatorSelection(AuthenticatorSelection authenticatorSelection) {
        this.authenticatorSelection = authenticatorSelection;
    }

    public PublicKeyCredentialCreationOptions attestation(Attestation attestation) {
        this.attestation = attestation;
        return this;
    }

    /**
     * Get attestation
     *
     * @return attestation
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Attestation getAttestation() {
        return attestation;
    }

    public void setAttestation(Attestation attestation) {
        this.attestation = attestation;
    }

    public PublicKeyCredentialCreationOptions extensions(Extensions extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Get extensions
     *
     * @return extensions
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Extensions getExtensions() {
        return extensions;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) o;
        return Objects.equals(this.rp, publicKeyCredentialCreationOptions.rp) &&
                Objects.equals(this.user, publicKeyCredentialCreationOptions.user) &&
                Objects.equals(this.challenge, publicKeyCredentialCreationOptions.challenge) &&
                Objects.equals(this.pubKeyCredParams, publicKeyCredentialCreationOptions.pubKeyCredParams) &&
                Objects.equals(this.timeout, publicKeyCredentialCreationOptions.timeout) &&
                Objects.equals(this.excludeCredentials, publicKeyCredentialCreationOptions.excludeCredentials) &&
                Objects.equals(this.authenticatorSelection, publicKeyCredentialCreationOptions.authenticatorSelection) &&
                Objects.equals(this.attestation, publicKeyCredentialCreationOptions.attestation) &&
                Objects.equals(this.extensions, publicKeyCredentialCreationOptions.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rp, user, challenge, pubKeyCredParams, timeout, excludeCredentials, authenticatorSelection, attestation, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublicKeyCredentialCreationOptions {\n");

        sb.append("    rp: ").append(toIndentedString(rp)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    challenge: ").append(toIndentedString(challenge)).append("\n");
        sb.append("    pubKeyCredParams: ").append(toIndentedString(pubKeyCredParams)).append("\n");
        sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
        sb.append("    excludeCredentials: ").append(toIndentedString(excludeCredentials)).append("\n");
        sb.append("    authenticatorSelection: ").append(toIndentedString(authenticatorSelection)).append("\n");
        sb.append("    attestation: ").append(toIndentedString(attestation)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
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
