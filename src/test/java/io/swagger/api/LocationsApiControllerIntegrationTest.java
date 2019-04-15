package io.swagger.api;

import io.swagger.model.Location;
import io.swagger.model.LocationUpdateRequest;
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
public class LocationsApiControllerIntegrationTest {

    @Autowired
    private LocationsApi api;

    @Test
    public void createLocationTest() throws Exception {
        ResponseEntity<Location> responseEntity = api.createLocation();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteLocationTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Void> responseEntity = api.deleteLocation(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getLocationTest() throws Exception {
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Location> responseEntity = api.getLocation(id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getLocationsTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<List<Location>> responseEntity = api.getLocations(include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateLocationTest() throws Exception {
        LocationUpdateRequest body = new LocationUpdateRequest();
        Integer id = 56;
        List<String> include = Arrays.asList("include_example");
        ResponseEntity<Location> responseEntity = api.updateLocation(body, id, include);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
