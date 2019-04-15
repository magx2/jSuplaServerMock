package io.swagger.api;

import io.swagger.model.Schedule;
import io.swagger.model.ScheduleRequest;
import io.swagger.model.SchedulesEnableRequest;
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
public class SchedulesApiControllerIntegrationTest {

    @Autowired
    private SchedulesApi api;

    @Test
    public void createScheduleTest() throws Exception {
        ScheduleRequest body = new ScheduleRequest();
        ResponseEntity<Schedule> responseEntity = api.createSchedule(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteScheduleTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteSchedule(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void enableSchedulesTest() throws Exception {
        SchedulesEnableRequest body = new SchedulesEnableRequest();
        ResponseEntity<Void> responseEntity = api.enableSchedules(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getScheduleTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Schedule> responseEntity = api.getSchedule(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getSchedulesTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<Schedule>> responseEntity = api.getSchedules(include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateScheduleTest() throws Exception {
        ScheduleRequest body = new ScheduleRequest();
        Integer id = 56;
        Boolean enable = true;
        ResponseEntity<Schedule> responseEntity = api.updateSchedule(body, id, enable);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
