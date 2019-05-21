package pl.grzeslowski.jsuplaservermock.service;

import io.swagger.model.Device;

import java.util.List;

public interface DeviceService {
    Device get(int id);

    List<Device> getAll();

    Device changeDeviceComment(int id, String comment);

    Device changeDeviceEnabled(int id, Boolean enabled);

    Device changeDeviceLocationId(int id, int locationId);

    void deleteDevice(int id);
}
