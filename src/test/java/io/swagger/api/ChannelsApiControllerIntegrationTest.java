package io.swagger.api;

import io.swagger.model.Channel;
import io.swagger.model.ChannelExecuteActionRequest;
import io.swagger.model.ChannelMeasurementLog;
import io.swagger.model.ChannelUpdateRequest;
import io.swagger.model.Schedule;
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
public class ChannelsApiControllerIntegrationTest {

    @Autowired
    private ChannelsApi api;

    @Test
    public void executeActionTest() throws Exception {
        ChannelExecuteActionRequest body = new ChannelExecuteActionRequest();
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.executeAction(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Channel> responseEntity = api.getChannel(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelMeasurementLogsTest() throws Exception {
        Integer id = 56;
        Integer limit = 56;
        Integer offset = 56;
        ResponseEntity<List<ChannelMeasurementLog>> responseEntity = api.getChannelMeasurementLogs(id, limit, offset);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelMeasurementLogsCsvFileTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.getChannelMeasurementLogsCsvFile(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelSchedulesTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<Schedule>> responseEntity = api.getChannelSchedules(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getChannelsTest() throws Exception {
//        List<String> include = Arrays.asList("include_example");
//        List<ChannelFunctionEnumNames> function = Arrays.asList(new ChannelFunctionEnumNames());
//        String io = "io_example";
//        Boolean hasFunction = true;
//        ResponseEntity<List<Channel>> responseEntity = api.getChannels(include, function, io, hasFunction);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateChannelTest() throws Exception {
        ChannelUpdateRequest body = new ChannelUpdateRequest();
        Integer id = 56;
        ResponseEntity<Channel> responseEntity = api.updateChannel(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
