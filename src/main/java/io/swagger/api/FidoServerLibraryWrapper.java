package io.swagger.api;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.yubico.webauthn.*;
import com.yubico.webauthn.data.*;
import com.yubico.webauthn.exception.AssertionFailedException;
import com.yubico.webauthn.exception.RegistrationFailedException;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class FidoServerLibraryWrapper {
    RelyingParty rp;
    PublicKeyCredentialCreationOptions registrationRequest;
    AssertionRequest authenticationRequest;
    FidoStorage storage;
    String sCredentialNickname = "Adult";
    byte[] userHandle;
    String username;

    // Handle calling FIDO library for generating registration request for client authenticator.
    public String start_registration(String sUsername, String sDisplayName) {
        this.username = sUsername;
        // Generate new user ID. This will be sent to the VCIssuer application so we won't need to create this.
        Random rd = new Random();
        this.userHandle = new byte[64];
        rd.nextBytes(this.userHandle);

        // Create request.
        this.registrationRequest = this.setRp().startRegistration(StartRegistrationOptions.builder()
                .user(UserIdentity.builder()
                        // Build new user to register new key to.
                        .name(sUsername)                                    // Username for user. Should be unique.
                        .displayName(sDisplayName)
                        .id(new ByteArray(this.userHandle))            // User handle, used for linking credential public keys to users. Maximum size of 64 bytes.
                        .build())
                .authenticatorSelection(AuthenticatorSelectionCriteria.builder()
                        .requireResidentKey(false)
                        .build()
                )
                .build());

        // Serialise request to JSON and send it to the client.
        ObjectMapper jsonMapper = new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .setSerializationInclusion(Include.NON_ABSENT)
                .registerModule(new Jdk8Module());

        String sRequest_json = "";
        try {
            // Generate a request ID so we can retrieve registration details when client POSTS to finish_registration URL.
            byte[] newRequestId = new byte[32];
            rd.nextBytes(newRequestId);
            String sNewRequestId_json = jsonMapper.writeValueAsString(newRequestId);

            sRequest_json = jsonMapper.writeValueAsString(this.registrationRequest);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Return JSON registration response object to RestController to send to client for a registration response.
        return sRequest_json;
    }

    public String finish_registration(String sRegisterResponse_json) {
        String sRegistrationResult_json = "";
        try {
            // Parse JSON response from client.
            PublicKeyCredential<AuthenticatorAttestationResponse, ClientRegistrationExtensionOutputs> pkc =
                    PublicKeyCredential.parseRegistrationResponseJson(sRegisterResponse_json);

            // Validate the message.
            RegistrationResult result = this.rp.finishRegistration(FinishRegistrationOptions.builder()
                    .request(this.registrationRequest)
                    .response(pkc)
                    .build());

            // Create new credential to persist.
            RegisteredCredential newRegisteredCredential = RegisteredCredential.builder()
                    .credentialId(result.getKeyId().getId())
                    .userHandle(new ByteArray(this.userHandle))
                    .publicKeyCose(result.getPublicKeyCose())
                    .build();

            // Update database (storage).
            this.storage.saveRegistration(this.username, this.sCredentialNickname, newRegisteredCredential);

            sRegistrationResult_json = "{\"status\": \"ok\",\"errorMessage\": \"\"}";
        } catch (RegistrationFailedException e) {
            e.printStackTrace();
            // return "{\"status\": \"failed\",\"errorMessage\": \"Server RegistrationFailedException thrown\"}";
        } catch (IOException e) {
            e.printStackTrace();
            // return "{\"status\": \"failed\",\"errorMessage\": \"Server IOException thrown\"}";
        }

        return sRegistrationResult_json;
    }

    public String start_authentication(String sUsername) {
        String sAuthenticationRequest_json = "";
        ObjectMapper jsonMapper = new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .setSerializationInclusion(Include.NON_ABSENT)
                .registerModule(new Jdk8Module());

        // Assuming that now FIDO storage is implemented, this should generate allowCredentials values (associated with sUsername).
        this.authenticationRequest = this.rp.startAssertion(StartAssertionOptions.builder()
                .username(Optional.of(sUsername))
                .build());
        try {
            sAuthenticationRequest_json = jsonMapper.writeValueAsString(this.authenticationRequest);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sAuthenticationRequest_json;
    }

    public String finish_authentication(String sAuthenticationResponse_json) {
        String sAuthenticationResult_json = "";
        PublicKeyCredential<AuthenticatorAssertionResponse, ClientAssertionExtensionOutputs> pkc;

        try {
            // Start by testing we don't get exceptions for the data from CTAP client library.
            pkc = PublicKeyCredential.parseAssertionResponseJson(sAuthenticationResponse_json);

            AssertionResult result = this.rp.finishAssertion(FinishAssertionOptions.builder()
                    .request(this.authenticationRequest)
                    .response(pkc)
                    .build());

            if (result.isSuccess()) {
                sAuthenticationResult_json = "{\"status\": \"ok\",\"errorMessage\": \"\"}";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AssertionFailedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sAuthenticationResult_json;
    }

    private RelyingParty setRp() {
        // Need to create entity identity that can issue new credentials.
        RelyingPartyIdentity rpIdentity = RelyingPartyIdentity.builder()
                .id("chadwickd.uok.ac.uk")
                .name("Test VCIssuer")
                .build();

        // The RelyingParty needs interface to D.B where credentials are stored.
        this.storage = new FidoStorage();

        this.rp = RelyingParty.builder()
                .identity(rpIdentity)
                .credentialRepository(this.storage)
                .build();

        return rp;
    }
}