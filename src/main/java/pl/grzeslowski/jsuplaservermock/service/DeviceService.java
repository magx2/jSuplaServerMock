package pl.grzeslowski.jsuplaservermock.service;

import io.swagger.model.Device;

import java.util.List;

public interface DeviceService {
    Device getDevice(int id);

    List<Device> getAllDevices();

    Device changeDeviceComment(int id, String comment);

    Device changeDeviceEnabled(int id, boolean enabled);

    Device changeDeviceLocationId(int id, int locationId);

    void deleteDevice(int id);
}
