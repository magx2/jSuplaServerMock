package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Schedule;
import io.swagger.model.ScheduleRequest;
import io.swagger.model.SchedulesEnableRequest;
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
public class SchedulesApiController implements SchedulesApi {

    private static final Logger log = LoggerFactory.getLogger(SchedulesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SchedulesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Schedule> createSchedule(@ApiParam(value = "", required = true) @Valid @RequestBody ScheduleRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Schedule>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSchedule(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> enableSchedules(@ApiParam(value = "", required = true) @Valid @RequestBody SchedulesEnableRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Schedule> getSchedule(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channel, iodevice, location, closestExecutions") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Schedule>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Schedule>> getSchedules(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "channel, iodevice, location, closestExecutions") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Schedule>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Schedule> updateSchedule(@ApiParam(value = "", required = true) @Valid @RequestBody ScheduleRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Set to `true` to enable the schedule after saving.") @Valid @RequestParam(value = "enable", required = false) Boolean enable) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Schedule>(HttpStatus.NOT_IMPLEMENTED);
    }

}
