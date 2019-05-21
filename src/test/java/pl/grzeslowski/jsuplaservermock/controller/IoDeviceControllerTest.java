package pl.grzeslowski.jsuplaservermock.controller;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import io.swagger.model.Channel;
import io.swagger.model.Device;
import io.swagger.model.IODeviceUpdateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import pl.grzeslowski.jsuplaservermock.service.DeviceService;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@SuppressWarnings("WeakerAccess")
@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBeansExtension.class)
class IoDeviceControllerTest {
    @InjectMocks IoDeviceController controller;
    @Mock DeviceService deviceService;

    @Random(excludes = {
            "location.iodevices",
            "location.channelGroups",
            "location.accessIds",
            "location.channels",
            "originalLocation",
            "channels.iodevice",
            "channels.location",
            "schedules.channel",
            "schedules.closestExecutions"}) Device device;
    @Random(type = Device.class,
            excludes = {
                    "location.iodevices",
                    "location.channelGroups",
                    "location.accessIds",
                    "location.channels",
                    "originalLocation",
                    "channels.iodevice",
                    "channels.location",
                    "schedules.channel",
                    "schedules.closestExecutions"}) List<Device> devices;

    @Test
    @DisplayName("should return IO device")
    void getIoDevice() {
        // given
        final int id = device.getId();
        given(deviceService.get(id)).willReturn(device);

        // when
        ResponseEntity<Device> responseEntity = controller.getIoDevice(id, emptyList());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(device);
    }

    @Test
    @DisplayName("should return IO devices")
    void getIoDevices() {
        // given
        given(deviceService.getAll()).willReturn(devices);

        // when
        ResponseEntity<List<Device>> responseEntity = controller.getIoDevices(emptyList());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(devices);
    }

    @Test
    @DisplayName("should change comment for Device")
    void updateIoDeviceComment(@Random String comment) {
        // given
        final IODeviceUpdateRequest request = new IODeviceUpdateRequest().comment(comment);
        given(deviceService.changeDeviceComment(device.getId(), comment)).willReturn(device);

        // when
        ResponseEntity<Device> responseEntity = controller.updateIoDevice(request, device.getId());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(device);
        verify(deviceService).changeDeviceComment(device.getId(), comment);
    }

    @Test
    @DisplayName("should change enabled for Device")
    void updateIoDeviceEnabled(@Random boolean enabled) {
        // given
        final IODeviceUpdateRequest request = new IODeviceUpdateRequest().enabled(enabled);
        given(deviceService.changeDeviceEnabled(device.getId(), enabled)).willReturn(device);

        // when
        ResponseEntity<Device> responseEntity = controller.updateIoDevice(request, device.getId());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(device);
        verify(deviceService).changeDeviceEnabled(device.getId(), enabled);
    }

    @Test
    @DisplayName("should change location ID for Device")
    void updateIoDeviceLocationId(@Random int locationId) {
        // given
        final IODeviceUpdateRequest request = new IODeviceUpdateRequest().locationId(locationId);
        given(deviceService.changeDeviceLocationId(device.getId(), locationId)).willReturn(device);

        // when
        ResponseEntity<Device> responseEntity = controller.updateIoDevice(request, device.getId());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(device);
        verify(deviceService).changeDeviceLocationId(device.getId(), locationId);
    }

    @Test
    @DisplayName("should change comment, enabled, location ID for Device")
    void updateIoDeviceCommentEnabledLocationId(@Random String comment, @Random boolean enabled, @Random int locationId) {
        // given
        final IODeviceUpdateRequest request = new IODeviceUpdateRequest()
                                                      .comment(comment)
                                                      .enabled(enabled)
                                                      .locationId(locationId);
        given(deviceService.changeDeviceComment(device.getId(), comment)).willReturn(device);
        given(deviceService.changeDeviceEnabled(device.getId(), enabled)).willReturn(device);
        given(deviceService.changeDeviceLocationId(device.getId(), locationId)).willReturn(device);

        // when
        ResponseEntity<Device> responseEntity = controller.updateIoDevice(request, device.getId());

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful())
                .as(responseEntity.toString())
                .isTrue();
        assertThat(responseEntity.getBody()).isEqualTo(device);
        verify(deviceService).changeDeviceComment(device.getId(), comment);
        verify(deviceService).changeDeviceEnabled(device.getId(), enabled);
        verify(deviceService).changeDeviceLocationId(device.getId(), locationId);
    }

    @Test
    @DisplayName("should return 400 when there is no action set")
    void updateIoDeviceNone() {
        // given
        final IODeviceUpdateRequest request = new IODeviceUpdateRequest();

        // when
        ResponseEntity<Device> responseEntity = controller.updateIoDevice(request, device.getId());

        // then
        assertThat(responseEntity.getStatusCode().is4xxClientError())
                .as(responseEntity.toString())
                .isTrue();
        verifyZeroInteractions(deviceService);
    }

    @Test
    @DisplayName("should return unimplemented for device channels")
    void getIoDeviceChannels() {
        // when
        final ResponseEntity<Channel> responseEntity = controller.getIoDeviceChannels(device.getId(), emptyList());

        // then
        assertThat(responseEntity.getStatusCode())
                .as(responseEntity.toString())
                .isEqualTo(NOT_IMPLEMENTED);
    }

    @Test
    @DisplayName("should delete device")
    void deleteIoDevice() {
        // when
        final ResponseEntity<Void> responseEntity = controller.deleteIoDevice(device.getId());

        // then
        assertThat(responseEntity.getStatusCode())
                .as(responseEntity.toString())
                .isEqualTo(NO_CONTENT);
        verify(deviceService).deleteDevice(device.getId());
    }
}
