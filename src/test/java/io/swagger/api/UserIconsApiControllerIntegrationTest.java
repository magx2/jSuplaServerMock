package io.swagger.api;

import io.swagger.model.AccessIdentifier;
import io.swagger.model.ChannelFunctionEnumNames;
import io.swagger.model.UserIcon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIconsApiControllerIntegrationTest {

    @Autowired
    private UserIconsApi api;

    @Test
    public void createUserIconTest() throws Exception {
        ChannelFunctionEnumNames function = new ChannelFunctionEnumNames();
        Integer sourceIcon = 56;
        File image1 = new org.springframework.core.io.FileSystemResource(new java.io.File("image1_example"));
        File image2 = new org.springframework.core.io.FileSystemResource(new java.io.File("image2_example"));
        File image3 = new org.springframework.core.io.FileSystemResource(new java.io.File("image3_example"));
        File image4 = new org.springframework.core.io.FileSystemResource(new java.io.File("image4_example"));
        ResponseEntity<AccessIdentifier> responseEntity = api.createUserIcon(function, sourceIcon, image1, image2, image3, image4);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void deleteUserIconTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Void> responseEntity = api.deleteUserIcon(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getUserIconsTest() throws Exception {
        List<String> include = Arrays.asList("include_example");
        List<ChannelFunctionEnumNames> function = Arrays.asList(new ChannelFunctionEnumNames());
        List<Integer> ids = Arrays.asList(56);
        ResponseEntity<List<UserIcon>> responseEntity = api.getUserIcons(include, function, ids);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void userIconsIdImageIndexGetTest() throws Exception {
        Integer id = 56;
        Integer imageIndex = 56;
        ResponseEntity<File> responseEntity = api.userIconsIdImageIndexGet(id, imageIndex);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
