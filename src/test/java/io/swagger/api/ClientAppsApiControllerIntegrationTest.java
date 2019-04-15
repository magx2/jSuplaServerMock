package io.swagger.api;

import io.swagger.model.ClientApp;
import io.swagger.model.ClientAppUpdateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientAppsApiControllerIntegrationTest {

    @Autowired
    private ClientAppsApi api;

    @Test
    public void deleteClientAppTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteClientApp(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getClientAppsTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<ClientApp>> responseEntity = api.getClientApps(include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateClientAppTest() throws Exception {
        ClientAppUpdateRequest body = new ClientAppUpdateRequest();
        Integer id = 56;
        ResponseEntity<ClientApp> responseEntity = api.updateClientApp(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
