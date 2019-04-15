package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Location;
import io.swagger.model.LocationUpdateRequest;
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
public class LocationsApiController implements LocationsApi {

    private static final Logger log = LoggerFactory.getLogger(LocationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LocationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Location> createLocation() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Location>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteLocation(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, iodevices, accessids, channelGroups, password") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Location> getLocation(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, iodevices, accessids, channelGroups, password") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Location>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Location>> getLocations(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, iodevices, accessids, channelGroups, password") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Location>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Location> updateLocation(@ApiParam(value = "", required = true) @Valid @RequestBody LocationUpdateRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, iodevices, accessids, channelGroups, password") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Location>(HttpStatus.NOT_IMPLEMENTED);
    }

}
