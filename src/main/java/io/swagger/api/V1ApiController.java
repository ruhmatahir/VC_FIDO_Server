package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
@Controller
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private FidoServerLibraryWrapper fslw = new FidoServerLibraryWrapper();

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // public ResponseEntity<ServerResponse> finishAuthentication(@ApiParam(value = "Authentication response from the Authenticator" ,required=true )  @Valid @RequestBody AuthenticatorAssertionResponse body) {
    @Override
    public ResponseEntity<String> finishAuthentication(@ApiParam(value = "Authentication response from the Authenticator", required = true) @Valid @RequestBody String body) {
    	/*
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerResponse>(objectMapper.readValue("{\n  \"errorMessage\" : \"errorMessage\",\n  \"status\" : \"ok\"\n}", ServerResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        */

        // Client JSON comes wrapped in quotation characters, which we need to remove before we can parse.
        String formattedClientJson = body.substring(1, body.length() - 1);
        // Client JSON format with single quotes instead of double quotes. Need to replace before JSON can be parsed by Jackson library.
        formattedClientJson = formattedClientJson.replace('\'', '"');

        String sAuthenticationResult_json = this.fslw.finish_authentication(formattedClientJson);

        // Send authentication result to client.
        if (sAuthenticationResult_json.equals("")) {
            return new ResponseEntity<String>("{\"status\": \"failed\",\"errorMessage\": \"Authentication process failed\"}", HttpStatus.METHOD_FAILURE);
        } else {
            return new ResponseEntity<String>(sAuthenticationResult_json, HttpStatus.OK);
        }

        // return new ResponseEntity<ServerResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    // public ResponseEntity<ServerResponse> finishRegistration(@ApiParam(value = "Registration response" ,required=true )  @Valid @RequestBody AuthenticatorAttestationResponse body) {
    // Make same changes that were made to startRegistration.
    @Override
    public ResponseEntity<String> finishRegistration(@ApiParam(value = "Registration response", required = true) @Valid @RequestBody String body) {
    	/*
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerResponse>(objectMapper.readValue("{\n  \"errorMessage\" : \"errorMessage\",\n  \"status\" : \"ok\"\n}", ServerResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialise response for content type application/json", e);
                return new ResponseEntity<ServerResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        */

        // Client JSON comes wrapped in quotation characters, which we need to remove before we can parse.
        String formattedClientJson = body.substring(1, body.length() - 1);
        // Client JSON format with single quotes instead of double quotes. Need to replace before JSON can be parsed by Jackson library.
        formattedClientJson = formattedClientJson.replace('\'', '"');
        String sRegisterResult_json = this.fslw.finish_registration(formattedClientJson);

        // Send registration result to client.
        if (sRegisterResult_json.equals("")) {
            return new ResponseEntity<String>("{\"status\": \"failed\",\"errorMessage\": \"Registration operation failed\"}", HttpStatus.METHOD_FAILURE);
        } else {
            return new ResponseEntity<String>(sRegisterResult_json, HttpStatus.OK);
        }

        // String sRegisterResult_json = "{\"status\": \"ok\",\"errorMessage\": \"\"}";
    }

    // public ResponseEntity<PublicKeyCredentialRequestOptions> startAuthentication(@ApiParam(value = "Request VP" ,required=true )  @Valid @RequestBody AuthenticationRequest body) {
    @Override
    public ResponseEntity<String> startAuthentication(@ApiParam(value = "Request VP", required = true) @Valid @RequestBody String body) {
    	/*
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PublicKeyCredentialRequestOptions>(objectMapper.readValue("{\n  \"extensions\" : { },\n  \"userVerification\" : \"required\",\n  \"challenge\" : \"\",\n  \"rp\" : {\n    \"name\" : \"Metrarc Ltd.\",\n    \"id\" : \"matrarc.com\"\n  },\n  \"allowCredentials\" : [ {\n    \"id\" : \"\",\n    \"type\" : \"public-key\"\n  }, {\n    \"id\" : \"\",\n    \"type\" : \"public-key\"\n  } ],\n  \"timeout\" : 60000,\n  \"username\" : \"username\"\n}", PublicKeyCredentialRequestOptions.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PublicKeyCredentialRequestOptions>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        */

        // Get user details from client.
        // Client JSON comes wrapped in quotation characters, which we need to remove before we can parse.
        String formattedClientJson = body.substring(1, body.length() - 1);
        JSONObject regCeremonyData = new JSONObject(formattedClientJson);
        String sUsername = regCeremonyData.getString("name");

        String sAuthenticationRequest_json = this.fslw.start_authentication(sUsername);

        // Send registration result to client.
        if (sAuthenticationRequest_json.equals("")) {
            return new ResponseEntity<String>("{\"status\": \"failed\",\"errorMessage\": \"Failed to init. authentication process\"}", HttpStatus.METHOD_FAILURE);
        } else {
            return new ResponseEntity<String>(sAuthenticationRequest_json, HttpStatus.OK);
        }

        // return new ResponseEntity<PublicKeyCredentialRequestOptions>(HttpStatus.NOT_IMPLEMENTED);
    }

    // public ResponseEntity<PublicKeyCredentialCreationOptions> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge" ,required=true )  @Valid @RequestBody RegistrationRequest body) {
    // public ResponseEntity<PublicKeyCredentialCreationOptions> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge" ,required=true )  @Valid @RequestBody String body) {
    // Update parameters to match V1Api class.
    @Override
    public ResponseEntity<String> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge", required = true) @Valid @RequestBody String body) {
    	/*
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PublicKeyCredentialCreationOptions>(objectMapper.readValue("{\n  \"extensions\" : { },\n  \"attestation\" : \"direct\",\n  \"challenge\" : \"\",\n  \"authenticatorSelection\" : {\n    \"userVerification\" : \"required\",\n    \"requireResidentKey\" : true\n  },\n  \"user\" : {\n    \"displayname\" : \"Ruhma Tahir\",\n    \"name\" : \"ruhma@metrarc.com\",\n    \"id\" : \"\"\n  },\n  \"rp\" : {\n    \"name\" : \"Metrarc Ltd.\",\n    \"id\" : \"matrarc.com\"\n  },\n  \"timeout\" : 60000,\n  \"excludeCredentials\" : [ {\n    \"credentialId\" : \"\",\n    \"PublicKeyCredentialType\" : 6\n  }, {\n    \"credentialId\" : \"\",\n    \"PublicKeyCredentialType\" : 6\n  } ],\n  \"pubKeyCredParams\" : [ {\n    \"type\" : \"public-key\",\n    \"alg\" : 0\n  }, {\n    \"type\" : \"public-key\",\n    \"alg\" : 0\n  } ]\n}", PublicKeyCredentialCreationOptions.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialise response for content type application/json", e);
                return new ResponseEntity<PublicKeyCredentialCreationOptions>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        */

        // Get user details from client.
        // Client JSON comes wrapped in quotation characters, which we need to remove before we can parse.
        String formattedClientJson = body.substring(1, body.length() - 1);
        JSONObject regCeremonyData = new JSONObject(formattedClientJson);
        String sUsername = regCeremonyData.getString("username");
        String sDisplayName = regCeremonyData.getString("displayName");

        // Generate registration request to send to client.
        String sRegReq_json = this.fslw.start_registration(sUsername, sDisplayName);

        // Send registration result to client.
        if (sRegReq_json.equals("")) {
            return new ResponseEntity<String>("{\"status\": \"failed\",\"errorMessage\": \"Failed to init. registration process\"}", HttpStatus.METHOD_FAILURE);
        } else {
            return new ResponseEntity<String>(sRegReq_json, HttpStatus.OK);
        }

        // return new ResponseEntity<PublicKeyCredentialCreationOptions>( HttpStatus.NOT_IMPLEMENTED );
    }

}
