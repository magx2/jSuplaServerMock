package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.ActionableSubjectTypeEnum;
import io.swagger.model.AuditEntry;
import io.swagger.model.DirectLink;
import io.swagger.model.DirectLinkRequest;
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
public class DirectLinksApiController implements DirectLinksApi {

    private static final Logger log = LoggerFactory.getLogger(DirectLinksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DirectLinksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<DirectLink> createDirectLink(@ApiParam(value = "") @Valid @RequestBody DirectLinkRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DirectLink>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteDirectLink(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DirectLink> getDirectLink(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "subject") @Valid @RequestParam(value = "include", required = false) List<String> include) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DirectLink>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<AuditEntry>> getDirectLinkAudit(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Page number, starting from 1.") @Valid @RequestParam(value = "page", required = false) Integer page, @ApiParam(value = "Page size, default 10.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<AuditEntry>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DirectLink>> getDirectLinks(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "subject") @Valid @RequestParam(value = "include", required = false) List<String> include, @ApiParam(value = "Filter direct links by subjectType and subjectId (must go together).") @Valid @RequestParam(value = "subjectType", required = false) ActionableSubjectTypeEnum subjectType, @ApiParam(value = "Filter direct links by subjectType and subjectId (must go together).") @Valid @RequestParam(value = "subjectId", required = false) Integer subjectId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<DirectLink>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DirectLink> updateDirectLink(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "") @Valid @RequestBody DirectLinkRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DirectLink>(HttpStatus.NOT_IMPLEMENTED);
    }

}
