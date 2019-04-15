package io.swagger.api;

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
public class ServerStatusApiControllerIntegrationTest {

    @Autowired
    private ServerStatusApi api;

    @Test
    public void getSuplaServerStatusTest() throws Exception {
        ResponseEntity<Void> responseEntity = api.getSuplaServerStatus();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
