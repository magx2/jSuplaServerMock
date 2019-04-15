package io.swagger.api;

import io.swagger.model.UserData;
import io.swagger.model.UserUpdateRequest;
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
public class UsersApiControllerIntegrationTest {

    @Autowired
    private UsersApi api;

    @Test
    public void getCurrentUserTest() throws Exception {
        ResponseEntity<UserData> responseEntity = api.getCurrentUser();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void updateCurrentUserTest() throws Exception {
        UserUpdateRequest body = new UserUpdateRequest();
        ResponseEntity<Void> responseEntity = api.updateCurrentUser(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
