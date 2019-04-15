package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.ClientApp;
import io.swagger.model.ClientAppUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Controller
public class ClientAppsApiController implements ClientAppsApi {

    private static final Logger log = LoggerFactory.getLogger(ClientAppsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ClientAppsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteClientApp(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ClientApp>> getClientApps(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "accessId, connected") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<ClientApp>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ClientApp> updateClientApp(@ApiParam(value = "", required = true) @Valid @RequestBody ClientAppUpdateRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<ClientApp>(HttpStatus.NOT_IMPLEMENTED);
    }

}
