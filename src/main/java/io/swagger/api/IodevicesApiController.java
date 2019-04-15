package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Channel;
import io.swagger.model.Device;
import io.swagger.model.IODeviceUpdateRequest;
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
public class IodevicesApiController implements IodevicesApi {

    private static final Logger log = LoggerFactory.getLogger(IodevicesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IodevicesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteIoDevice(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Device> getIoDevice(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, location, originalLocation, connected, schedules, accessids") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Device>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Channel> getIoDeviceChannels(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "iodevice, location") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Channel>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Device>> getIoDevices(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, location, originalLocation, connected, schedules") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Device>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Device> updateIoDevice(@ApiParam(value = "", required = true) @Valid @RequestBody IODeviceUpdateRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Device>(HttpStatus.NOT_IMPLEMENTED);
    }

}
