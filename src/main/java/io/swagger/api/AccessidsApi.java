/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.model.AccessIdentifier;
import io.swagger.model.AccessIdentifierUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Api(value = "accessids", description = "the accessids API")
public interface AccessidsApi {

    @ApiOperation(value = "Create a new Access Identifier", nickname = "createAccessIdentifier", notes = "", response = AccessIdentifier.class, authorizations = {
            @Authorization(value = "BearerAuth"),
            @Authorization(value = "OAuth2", scopes = {
                    @AuthorizationScope(scope = "", description = "")})}, tags = {"Access Identifiers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Newely created AccessIdentifier with automatic name", response = AccessIdentifier.class)})
    @RequestMapping(value = "/accessids",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<AccessIdentifier> createAccessIdentifier();

    @ApiOperation(value = "Delete Access Identifier", nickname = "deleteAccessIdentifier", notes = "", authorizations = {
            @Authorization(value = "BearerAuth"),
            @Authorization(value = "OAuth2", scopes = {
                    @AuthorizationScope(scope = "", description = "")})}, tags = {"Access Identifiers",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Access Identifier has been successfully deleted")})
    @RequestMapping(value = "/accessids/{id}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAccessIdentifier(@ApiParam(value = "", required = true) @PathVariable("id") Integer id);

    @ApiOperation(value = "Get Access Identifier", nickname = "getAccessIdentifier", notes = "", response = AccessIdentifier.class, authorizations = {
            @Authorization(value = "BearerAuth"),
            @Authorization(value = "OAuth2", scopes = {
                    @AuthorizationScope(scope = "", description = "")})}, tags = {"Access Identifiers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Access Identifier", response = AccessIdentifier.class)})
    @RequestMapping(value = "/accessids/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<AccessIdentifier> getAccessIdentifier(@ApiParam(value = "", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "locations, clientApps, password") @Valid @RequestParam(value = "include", required = false) List<String> include);

    @ApiOperation(value = "Get Access Identifiers list", nickname = "getAccessIdentifiers", notes = "", response = AccessIdentifier.class, responseContainer = "List", authorizations = {
            @Authorization(value = "BearerAuth"),
            @Authorization(value = "OAuth2", scopes = {
                    @AuthorizationScope(scope = "", description = "")})}, tags = {"Access Identifiers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of Access Identifiers owned by the current user.", response = AccessIdentifier.class, responseContainer = "List")})
    @RequestMapping(value = "/accessids",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<AccessIdentifier>> getAccessIdentifiers(@ApiParam(value = "Specify what extra fields to include in the response.", allowableValues = "locations, clientApps, password") @Valid @RequestParam(value = "include", required = false) List<String> include);

    @ApiOperation(value = "Update Access Identifier", nickname = "updateAccessIdentifier", notes = "", response = AccessIdentifier.class, authorizations = {
            @Authorization(value = "BearerAuth"),
            @Authorization(value = "OAuth2", scopes = {
                    @AuthorizationScope(scope = "", description = "")})}, tags = {"Access Identifiers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Definition generated from Swagger Inspector", response = AccessIdentifier.class)})
    @RequestMapping(value = "/accessids/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<AccessIdentifier> updateAccessIdentifier(@ApiParam(value = "", required = true) @Valid @RequestBody AccessIdentifierUpdateRequest body, @ApiParam(value = "", required = true) @PathVariable("id") Integer id);

}
