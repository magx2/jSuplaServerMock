package io.swagger.api;

import io.swagger.model.ChannelExecuteActionRequest;
import io.swagger.model.ChannelGroup;
import io.swagger.model.ChannelGroupRequest;
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
public class ChannelGroupsApiControllerIntegrationTest {

    @Autowired
    private ChannelGroupsApi api;

    @Test
    public void createChannelGroupTest() throws Exception {
        ChannelGroupRequest body = new ChannelGroupRequest();
        ResponseEntity<ChannelGroup> responseEntity = api.createChannelGroup(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteChannelGroupTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteChannelGroup(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void executeChannelGroupActionTest() throws Exception {
        ChannelExecuteActionRequest body = new ChannelExecuteActionRequest();
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.executeChannelGroupAction(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelGroupTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<ChannelGroup> responseEntity = api.getChannelGroup(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelGroupsTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<ChannelGroup>> responseEntity = api.getChannelGroups(include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateChannelGroupTest() throws Exception {
        ChannelGroupRequest body = new ChannelGroupRequest();
        Integer id = 56;
        ResponseEntity<ChannelGroup> responseEntity = api.updateChannelGroup(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
