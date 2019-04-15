package pl.grzeslowski.jsuplaservermock;

import io.swagger.model.Channel;
import io.swagger.model.Device;
import io.swagger.model.ServerInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public final class Database {
    private final Set<Device> devices = new HashSet<>();
    private final String contextPath;
    private final String port;

    public Database(
            @Value("${server.contextPath}") final String contextPath,
            @Value("${server.port}") final String port) {
        this.contextPath = contextPath;
        this.port = port;
    }

    public List<Device> findAllDevices() {
        return new ArrayList<>(devices);
    }

    public Optional<Device> findDevice(int id) {
        return devices.stream()
                       .filter(d -> d.getId() == id)
                       .findAny();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Channel> findAllChannels() {
        return devices.stream()
                       .map(Device::getChannels)
                       .flatMap(Collection::stream)
                       .collect(Collectors.toList());
    }

    public Optional<Channel> findChannel(int id) {
        return findAllChannels()
                       .stream()
                       .filter(c -> c.getId() == id)
                       .findAny();
    }

    public ServerInfo getServerInfo() {
        return new ServerInfo()
                       .apiVersion("2.3.0")
                       .supportedApiVersions(Collections.singletonList("2.3.0"))
                       .cloudVersion("2.3.0")
                       .address("localhost" + contextPath + ":" + port);
    }
}
