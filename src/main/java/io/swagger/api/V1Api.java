/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.13).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.PublicKeyCredentialCreationOptions;
import io.swagger.model.PublicKeyCredentialRequestOptions;
import io.swagger.model.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
@Api(value = "v1", description = "the v1 API")
public interface V1Api {

    @ApiOperation(value = "Submit a signed challenge for authenication to the server.", nickname = "finishAuthentication", notes = "This method allows the client to return the signed challenge to the server to be verified.", response = ServerResponse.class, tags = {"Authentication",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation completed succssfully", response = ServerResponse.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/v1/AuthnResponse",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
        // ResponseEntity<ServerResponse> finishAuthentication(@ApiParam(value = "Authentication response from the Authenticator" ,required=true )  @Valid @RequestBody AuthenticatorAssertionResponse body);
    ResponseEntity<String> finishAuthentication(@ApiParam(value = "Authentication response from the Authenticator", required = true) @Valid @RequestBody String body);


    @ApiOperation(value = "Complete the registration by submitting a signed challenge to the server", nickname = "finishRegistration", notes = "Once the client has generated a authenticatorAttestationResponse to the server's registration request, this API must be called for the registration worrkflow to be completed.", response = ServerResponse.class, tags = {"Registration",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation completed succssfully", response = ServerResponse.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/v1/RegnResponse",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
        // ResponseEntity<ServerResponse> finishRegistration(@ApiParam(value = "Registration response" ,required=true )  @Valid @RequestBody AuthenticatorAttestationResponse body);
        // Make same changes that were made to startRegistration.
    ResponseEntity<String> finishRegistration(@ApiParam(value = "Registration response", required = true) @Valid @RequestBody String body);


    @ApiOperation(value = "Generate a authentication FIDO challenge for the client", nickname = "startAuthentication", notes = "During the authentication ceremony, users or the VCHolder will call this API  to initiate the authentication of a previously enrolled FIDO key.", response = PublicKeyCredentialRequestOptions.class, tags = {"Authentication",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Access Granted", response = PublicKeyCredentialRequestOptions.class),
            @ApiResponse(code = 400, message = "Invalid username supplied", response = ServerResponse.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/v1/Authenticate",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
        // ResponseEntity<PublicKeyCredentialRequestOptions> startAuthentication(@ApiParam(value = "Request VP" ,required=true )  @Valid @RequestBody AuthenticationRequest body);
    ResponseEntity<String> startAuthentication(@ApiParam(value = "Request VP", required = true) @Valid @RequestBody String body);


    @ApiOperation(value = "Generate a registration FIDO challenge for the client", nickname = "startRegistration", notes = "During the registration ceremony, when users or the VCHolder wants to initiate the registration of a new FIDO key, they will call this API. The users can send thier username or displayName as an optional request, but the server does not have to use those values when creating the response. The servcer response will be a JSON formatted PublicKeyCredentialCreationOptions dictionary, which will be used by the client in order  to create a PublicKeyCredential. ", response = PublicKeyCredentialCreationOptions.class, tags = {"Registration",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "FIDO challenge generated successfully", response = PublicKeyCredentialCreationOptions.class),
            @ApiResponse(code = 400, message = "Invalid username supplied", response = ServerResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/v1/Register",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
        // ResponseEntity<PublicKeyCredentialCreationOptions> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge" ,required=true )  @Valid @RequestBody RegistrationRequest body);
        // ResponseEntity<PublicKeyCredentialCreationOptions> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge" ,required=true )  @Valid @RequestBody String body);
        // Update parameters as String due to object not having valid constructors to parse JSON in generated code.
    ResponseEntity<String> startRegistration(@ApiParam(value = "Values needed from the client to create a FIDO registration challenge", required = true) @Valid @RequestBody String body);

}