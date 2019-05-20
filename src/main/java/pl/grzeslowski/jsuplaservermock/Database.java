package pl.grzeslowski.jsuplaservermock;

import io.swagger.model.Channel;
import io.swagger.model.Device;
import io.swagger.model.ServerInfo;

import java.util.List;
import java.util.Optional;

public interface Database {
    List<Device> findAllDevices();

    Optional<Device> findDevice(int id);

    void addDevice(Device device);

    List<Channel> findAllChannels();

    Optional<Channel> findChannel(int id);

    ServerInfo getServerInfo();
}
