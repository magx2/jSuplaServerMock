package io.swagger.api;

import io.swagger.model.Channel;
import io.swagger.model.Device;
import io.swagger.model.IODeviceUpdateRequest;
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
public class IodevicesApiControllerIntegrationTest {

    @Autowired
    private IodevicesApi api;

    @Test
    public void deleteIoDeviceTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteIoDevice(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getIoDeviceTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Device> responseEntity = api.getIoDevice(id, include);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getIoDeviceChannelsTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Channel> responseEntity = api.getIoDeviceChannels(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getIoDevicesTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<Device>> responseEntity = api.getIoDevices(include);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateIoDeviceTest() throws Exception {
        IODeviceUpdateRequest body = new IODeviceUpdateRequest();
        Integer id = 56;
        ResponseEntity<Device> responseEntity = api.updateIoDevice(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
