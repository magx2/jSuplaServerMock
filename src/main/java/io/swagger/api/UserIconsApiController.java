package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.AccessIdentifier;
import io.swagger.model.ChannelFunctionEnumNames;
import io.swagger.model.UserIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Controller
public class UserIconsApiController implements UserIconsApi {

    private static final Logger log = LoggerFactory.getLogger(UserIconsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserIconsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccessIdentifier> createUserIcon(@ApiParam(value = "") @RequestParam(value = "function", required = false) ChannelFunctionEnumNames function, @ApiParam(value = "") @RequestParam(value = "sourceIcon", required = false) Integer sourceIcon, @ApiParam(value = "") @RequestParam(value = "image1", required = false) File image1, @ApiParam(value = "") @RequestParam(value = "image2", required = false) File image2, @ApiParam(value = "") @RequestParam(value = "image3", required = false) File image3, @ApiParam(value = "") @RequestParam(value = "image4", required = false) File image4) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<AccessIdentifier>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUserIcon(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<UserIcon>> getUserIcons(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "images") @Valid @RequestParam(value = "include", required = false) List<String> include, @ApiParam(value = "Return only icons for given function") @Valid @RequestParam(value = "function", required = false) List<ChannelFunctionEnumNames> function, @ApiParam(value = "Return only icons with given identifiers") @Valid @RequestParam(value = "ids", required = false) List<Integer> ids) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<UserIcon>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<File> userIconsIdImageIndexGet(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "", required = true) @PathVariable("imageIndex") Integer imageIndex) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<File>(HttpStatus.NOT_IMPLEMENTED);
    }

}
