package io.swagger.api;

import io.swagger.model.AccessIdentifier;
import io.swagger.model.AccessIdentifierUpdateRequest;
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
public class AccessidsApiControllerIntegrationTest {

    @Autowired
    private AccessidsApi api;

    @Test
    public void createAccessIdentifierTest() throws Exception {
        ResponseEntity<AccessIdentifier> responseEntity = api.createAccessIdentifier();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteAccessIdentifierTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteAccessIdentifier(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAccessIdentifierTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<AccessIdentifier> responseEntity = api.getAccessIdentifier(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAccessIdentifiersTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<AccessIdentifier>> responseEntity = api.getAccessIdentifiers(include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateAccessIdentifierTest() throws Exception {
        AccessIdentifierUpdateRequest body = new AccessIdentifierUpdateRequest();
        Integer id = 56;
        ResponseEntity<AccessIdentifier> responseEntity = api.updateAccessIdentifier(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
