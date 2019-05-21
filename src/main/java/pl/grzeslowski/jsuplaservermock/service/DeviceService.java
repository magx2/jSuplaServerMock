package pl.grzeslowski.jsuplaservermock.service;

import io.swagger.model.Device;

import java.util.List;

public interface DeviceService {
    /**
     * Finds device with given ID.
     *
     * @param id ID of device to find
     * @return found device
     * @throws EntityNotFoundException when device with given ID does not exists
     */
    Device getDevice(int id);

    /**
     * Finds all devices.
     *
     * @return all devices
     */
    List<Device> getAllDevices();

    /**
     * Changes comment for device with given ID.
     *
     * @param id ID of device to change
     * @param comment new devices comment
     * @return changed device
     * @throws EntityNotFoundException when device with given ID does not exists
     */
    Device changeDeviceComment(int id, String comment);

    /**
     * Changes enabled for device with given ID.
     *
     * @param id ID of device to change
     * @param enabled is device enabled
     * @return changed device
     * @throws EntityNotFoundException when device with given ID does not exists
     */
    Device changeDeviceEnabled(int id, boolean enabled);

    /**
     * Changes location ID for device with given ID.
     *
     * @param id ID of device to change
     * @param locationId  ID of location
     * @return changed device
     * @throws EntityNotFoundException when device with given ID does not exists
     */
    Device changeDeviceLocationId(int id, int locationId);

    /**
     * Deletes device with given ID.
     *
     * @param id ID of device to delete
     * @throws EntityNotFoundException when device with given ID does not exists
     */
    void deleteDevice(int id);
}
