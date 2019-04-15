package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Channel;
import io.swagger.model.ChannelExecuteActionRequest;
import io.swagger.model.ChannelFunctionEnumNames;
import io.swagger.model.ChannelMeasurementLog;
import io.swagger.model.ChannelUpdateRequest;
import io.swagger.model.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.grzeslowski.jsuplaservermock.Database;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Controller
public class ChannelsApiController implements ChannelsApi {

    private static final Logger log = LoggerFactory.getLogger(ChannelsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final Database database;

    @org.springframework.beans.factory.annotation.Autowired
    public ChannelsApiController(ObjectMapper objectMapper, HttpServletRequest request, final Database database) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.database = database;
    }

    public ResponseEntity<Void> executeAction(@ApiParam(value = "Defines an action to execute on channel. The `action` key is always required. The rest of the keys are params depending on the chosen action. Read more on [Github Wiki](https://github.com/SUPLA/supla-cloud/wiki/Channel-Actions).", required = true) @Valid @RequestBody ChannelExecuteActionRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        // TODO implement
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Channel> getChannel(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "iodevice, location, connected, state, supportedFunctions, measurementLogsCount, relationsCount") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        return database.findChannel(id)
                       .map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ChannelMeasurementLog>> getChannelMeasurementLogs(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Maximum items count in response, from 1 to 5000") @Valid @RequestParam(value = "limit", required = false) Integer limit, @ApiParam(value = "Pagination offset") @Valid @RequestParam(value = "offset", required = false) Integer offset) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<ChannelMeasurementLog>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> getChannelMeasurementLogsCsvFile(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Schedule>> getChannelSchedules(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channel, iodevice, location, closestExecutions") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Schedule>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Channel>> getChannels(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "iodevice, location, connected, state") @Valid @RequestParam(value = "include", required = false) List<String> include, @ApiParam(value = "") @Valid @RequestParam(value = "function", required = false) List<ChannelFunctionEnumNames> function, @ApiParam(value = "Return only `input` or `output` channels.", allowableValues = "input, output") @Valid @RequestParam(value = "io", required = false) String io, @ApiParam(value = "Return only channels with (`true`) or without (`false`) chosen functions.") @Valid @RequestParam(value = "hasFunction", required = false) Boolean hasFunction) {
        return ok(database.findAllChannels());
    }

    public ResponseEntity<Channel> updateChannel(@ApiParam(value = "", required = true) @Valid @RequestBody ChannelUpdateRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Channel>(HttpStatus.NOT_IMPLEMENTED);
    }

}
