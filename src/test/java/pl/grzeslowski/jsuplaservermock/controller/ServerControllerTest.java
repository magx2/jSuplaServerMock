package pl.grzeslowski.jsuplaservermock.controller;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import io.swagger.model.ServerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import pl.grzeslowski.jsuplaservermock.service.ServerService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBeansExtension.class)
class ServerControllerTest {
    @InjectMocks ServerController controller;

    @Mock ServerService serverService;

    @Test
    @DisplayName("should return server info")
    void getServerInfo(@Random ServerInfo serverInfo) {
        // given
        given(serverService.getServerInfo()).willReturn(serverInfo);

        // when
        ResponseEntity<ServerInfo> response = controller.getServerInfo();

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.getStatusCode().toString())
                .isTrue();
        assertThat(response.getBody()).isEqualTo(serverInfo);
    }

    @Test
    @DisplayName("should return 200 at server status")
    void getServerStatus() {
        // when
        ResponseEntity<Void> response = controller.getSuplaServerStatus();

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.getStatusCode().toString())
                .isTrue();
    }
}
