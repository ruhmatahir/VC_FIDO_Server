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
import java.io.IOException;
import java.util.Base64;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-06T10:04:32.590Z[GMT]")
@Controller
public class FileApiController implements FileApi {

    private static final Logger log = LoggerFactory.getLogger(FileApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<byte[]> sendBase64URL(@ApiParam(value = "", required = true) @Valid @RequestBody byte[] body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<byte[]>(objectMapper.readValue("\"\"", byte[].class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // Get client JSON.
        String sClientJson = new String(body);

        // Parse client JSON.
        JSONObject obj = new JSONObject(sClientJson);
        String sEncodedData = obj.getString("clientMessage");

        // Decode base64-encoded data.
        byte[] decodedData = Base64.getUrlDecoder().decode(sEncodedData);

        // Encode data as base64.
        String sReencodedData = Base64.getUrlEncoder().encodeToString(decodedData);

        // Build JSON to send to client.
        String sJsonToReturn = "{\"clientMessage\":\"" + sReencodedData + "\"}";

        // Send JSON, with base64-encoded data, to client.
        return new ResponseEntity<byte[]>(sJsonToReturn.getBytes(), HttpStatus.OK);
    }

}
