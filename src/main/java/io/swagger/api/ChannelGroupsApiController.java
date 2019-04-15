package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.ChannelExecuteActionRequest;
import io.swagger.model.ChannelGroup;
import io.swagger.model.ChannelGroupRequest;
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
public class ChannelGroupsApiController implements ChannelGroupsApi {

    private static final Logger log = LoggerFactory.getLogger(ChannelGroupsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ChannelGroupsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ChannelGroup> createChannelGroup(@ApiParam(value = "", required = true) @Valid @RequestBody ChannelGroupRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<ChannelGroup>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteChannelGroup(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> executeChannelGroupAction(@ApiParam(value = "Defines an action to execute on channel group. The `action` key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions).", required = true) @Valid @RequestBody ChannelExecuteActionRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ChannelGroup> getChannelGroup(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels, iodevice, location, state, relationsCount") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<ChannelGroup>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ChannelGroup>> getChannelGroups(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channels") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<ChannelGroup>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ChannelGroup> updateChannelGroup(@ApiParam(value = "", required = true) @Valid @RequestBody ChannelGroupRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<ChannelGroup>(HttpStatus.NOT_IMPLEMENTED);
    }

}
