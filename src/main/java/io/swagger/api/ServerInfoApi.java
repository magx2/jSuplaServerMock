/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.ServerInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Api(value = "server-info", description = "the server-info API")
public interface ServerInfoApi {

    @ApiOperation(value = "Get server info", nickname = "getServerInfo", notes = "", response = ServerInfo.class, tags = {"Server",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ServerInfo.class)})
    @RequestMapping(value = "/server-info",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ServerInfo> getServerInfo();

}
