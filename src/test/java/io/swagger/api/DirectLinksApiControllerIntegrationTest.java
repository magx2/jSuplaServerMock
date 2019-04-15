package io.swagger.api;

import io.swagger.model.AuditEntry;
import io.swagger.model.DirectLink;
import io.swagger.model.DirectLinkRequest;
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
public class DirectLinksApiControllerIntegrationTest {

    @Autowired
    private DirectLinksApi api;

    @Test
    public void createDirectLinkTest() throws Exception {
        DirectLinkRequest body = new DirectLinkRequest();
        ResponseEntity<DirectLink> responseEntity = api.createDirectLink(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteDirectLinkTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteDirectLink(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getDirectLinkTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<DirectLink> responseEntity = api.getDirectLink(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getDirectLinkAuditTest() throws Exception {
        Integer id = 56;
        Integer page = 56;
        Integer pageSize = 56;
        ResponseEntity<List<AuditEntry>> responseEntity = api.getDirectLinkAudit(id, page, pageSize);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getDirectLinksTest() throws Exception {
//        List<String> include = Arrays.asList("include_example");
//        ActionableSubjectTypeEnum subjectType = new ActionableSubjectTypeEnum();
//        Integer subjectId = 56;
//        ResponseEntity<List<DirectLink>> responseEntity = api.getDirectLinks(include, subjectType, subjectId);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateDirectLinkTest() throws Exception {
        Integer id = 56;
        DirectLinkRequest body = new DirectLinkRequest();
        ResponseEntity<DirectLink> responseEntity = api.updateDirectLink(id, body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
