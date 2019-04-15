package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.ServerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import pl.grzeslowski.jsuplaservermock.Database;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-15T15:14:44.820Z[GMT]")
@Controller
public class ServerInfoApiController implements ServerInfoApi {

    private static final Logger log = LoggerFactory.getLogger(ServerInfoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final Database database;

    @org.springframework.beans.factory.annotation.Autowired
    public ServerInfoApiController(ObjectMapper objectMapper, HttpServletRequest request, final Database database) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.database = database;
    }

    public ResponseEntity<ServerInfo> getServerInfo() {
        return ok(database.getServerInfo());
    }

}
