package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * PublicKeyCredentialRequestOptions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
public class PublicKeyCredentialRequestOptions {
    @JsonProperty("rp")
    private Rp rp = null;

    @JsonProperty("challenge")
    private byte[] challenge = null;

    @JsonProperty("allowCredentials")
    private AllowCredentials allowCredentials = null;

    @JsonProperty("userVerification")
    private UserVerification userVerification = null;

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("timeout")
    private Integer timeout = null;

    @JsonProperty("extensions")
    private Object extensions = null;

    public PublicKeyCredentialRequestOptions rp(Rp rp) {
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

    public PublicKeyCredentialRequestOptions challenge(byte[] challenge) {
        this.challenge = challenge;
        return this;
    }

    /**
     * Get challenge
     *
     * @return challenge
     **/
    @ApiModelProperty(value = "")

    @Size(min = 16)
    public byte[] getChallenge() {
        return challenge;
    }

    public void setChallenge(byte[] challenge) {
        this.challenge = challenge;
    }

    public PublicKeyCredentialRequestOptions allowCredentials(AllowCredentials allowCredentials) {
        this.allowCredentials = allowCredentials;
        return this;
    }

    /**
     * Get allowCredentials
     *
     * @return allowCredentials
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public AllowCredentials getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(AllowCredentials allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public PublicKeyCredentialRequestOptions userVerification(UserVerification userVerification) {
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

    public PublicKeyCredentialRequestOptions username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     **/
    @ApiModelProperty(value = "")

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PublicKeyCredentialRequestOptions timeout(Integer timeout) {
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

    public PublicKeyCredentialRequestOptions extensions(Object extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Get extensions
     *
     * @return extensions
     **/
    @ApiModelProperty(value = "")

    public Object getExtensions() {
        return extensions;
    }

    public void setExtensions(Object extensions) {
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
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) o;
        return Objects.equals(this.rp, publicKeyCredentialRequestOptions.rp) &&
                Objects.equals(this.challenge, publicKeyCredentialRequestOptions.challenge) &&
                Objects.equals(this.allowCredentials, publicKeyCredentialRequestOptions.allowCredentials) &&
                Objects.equals(this.userVerification, publicKeyCredentialRequestOptions.userVerification) &&
                Objects.equals(this.username, publicKeyCredentialRequestOptions.username) &&
                Objects.equals(this.timeout, publicKeyCredentialRequestOptions.timeout) &&
                Objects.equals(this.extensions, publicKeyCredentialRequestOptions.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rp, challenge, allowCredentials, userVerification, username, timeout, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PublicKeyCredentialRequestOptions {\n");

        sb.append("    rp: ").append(toIndentedString(rp)).append("\n");
        sb.append("    challenge: ").append(toIndentedString(challenge)).append("\n");
        sb.append("    allowCredentials: ").append(toIndentedString(allowCredentials)).append("\n");
        sb.append("    userVerification: ").append(toIndentedString(userVerification)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
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
