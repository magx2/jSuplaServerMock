package io.swagger.api;

import io.swagger.model.ServerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerInfoApiControllerIntegrationTest {

    @Autowired
    private ServerInfoApi api;

    @Test
    public void getServerInfoTest() throws Exception {
        ResponseEntity<ServerInfo> responseEntity = api.getServerInfo();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
