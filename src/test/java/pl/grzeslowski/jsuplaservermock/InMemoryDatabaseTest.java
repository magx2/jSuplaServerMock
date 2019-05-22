package pl.grzeslowski.jsuplaservermock;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import io.swagger.model.Device;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.grzeslowski.jsuplaservermock.service.EntityNotFoundException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("WeakerAccess")
@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBeansExtension.class)
class InMemoryDatabaseTest {
    InMemoryDatabase database;

    @Random String contextPath;
    @Random String port;

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

    @BeforeEach
    void setUp() {
        database = new InMemoryDatabase(contextPath, port);
    }

    @Test
    @DisplayName("should get device from DB")
    void getDevice() {
        // given
        database.addDevice(device);

        // when
        final Device deviceFromDb = database.getDevice(device.getId());

        // then
        assertThat(deviceFromDb).isEqualTo(device);
    }

    @Test
    @DisplayName("should get device from DB")
    void getDeviceNotFound(@Random int id) {
        // when
        final ThrowableAssert.ThrowingCallable device = () -> database.getDevice(id);

        // then
        assertThatThrownBy(device).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("should get all devices from DB")
    void getAllDevices(@Random(type = Device.class,
            excludes = {
                    "location.iodevices",
                    "location.channelGroups",
                    "location.accessIds",
                    "location.channels",
                    "originalLocation",
                    "channels.iodevice",
                    "channels.location",
                    "schedules.channel",
                    "schedules.closestExecutions"}) List<Device> devices) {
        // given
        devices.forEach(device -> database.addDevice(device));

        // when
        final List<Device> devicesFromDb = database.getAllDevices();

        // then
        assertThat(devicesFromDb).containsExactlyInAnyOrder(devices.toArray(new Device[0]));
    }

    @Test
    @DisplayName("should change device comment")
    void changeDeviceComment(@Random String comment) {
        // given
        database.addDevice(device);

        // when
        final Device deviceFromDb = database.changeDeviceComment(this.device.getId(), comment);

        // then
        assertThat(deviceFromDb.getComment()).isEqualTo(comment);
        assertThat(database.getDevice(device.getId()).getComment()).isEqualTo(comment);
    }

    @Test
    @DisplayName("should throw EntityNotFoundException when cannot find device with given ID (comment)")
    void changeDeviceCommentEntityNotFound(@Random int id, @Random String comment) {
        // when
        final ThrowableAssert.ThrowingCallable device = () -> database.changeDeviceComment(id, comment);

        // then
        assertThatThrownBy(device).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("should change device enabled")
    void changeDeviceEnabled(@Random boolean enabled) {
        // given
        database.addDevice(device);

        // when
        final Device deviceFromDb = database.changeDeviceEnabled(this.device.getId(), enabled);

        // then
        assertThat(deviceFromDb.isEnabled()).isEqualTo(enabled);
        assertThat(database.getDevice(device.getId()).isEnabled()).isEqualTo(enabled);
    }

    @Test
    @DisplayName("should throw EntityNotFoundException when cannot find device with given ID (enabled)")
    void changeDeviceEnabledEntityNotFound(@Random int id, @Random boolean enabled) {
        // when
        final ThrowableAssert.ThrowingCallable device = () -> database.changeDeviceEnabled(id, enabled);

        // then
        assertThatThrownBy(device).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("should change device locationId")
    void changeDeviceLocationId(@Random int locationId) {
        // given
        database.addDevice(device);

        // when
        final Device deviceFromDb = database.changeDeviceLocationId(this.device.getId(), locationId);

        // then
        assertThat(deviceFromDb.getLocationId()).isEqualTo(locationId);
        // TODO implement with locations
//        assertThat(deviceFromDb.getLocation().getId()).isEqualTo(locationId);
        assertThat(database.getDevice(device.getId()).getLocationId()).isEqualTo(locationId);
        // TODO implement with locations
//        assertThat(database.getDevice(device.getId()).getId()).isEqualTo(locationId);
    }

    @Test
    @DisplayName("should throw EntityNotFoundException when cannot find device with given ID (locationId)")
    void changeDeviceLocationIdEntityNotFound(@Random int id, @Random int locationId) {
        // when
        final ThrowableAssert.ThrowingCallable device = () -> database.changeDeviceLocationId(id, locationId);

        // then
        assertThatThrownBy(device).isInstanceOf(EntityNotFoundException.class);
    }

    // TODO add test for changing locationId and location cannot be found

    @Test
    @DisplayName("should delete device with given ID")
    public void deleteDevice() {
        // given
        database.addDevice(device);

        // when
        database.deleteDevice(device.getId());

        // then
        assertThatThrownBy(() -> database.getDevice(device.getId())).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("should hrow EntityNotFoundException when cannot find device to delete")
    public void deleteDeviceEntityNotFound() {
        // when
        final ThrowableAssert.ThrowingCallable delete = () -> database.deleteDevice(device.getId());

        // then
        assertThatThrownBy(delete).isInstanceOf(EntityNotFoundException.class);
    }
}
