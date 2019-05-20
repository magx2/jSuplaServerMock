package pl.grzeslowski.jsuplaservermock

import io.swagger.model.Channel
import io.swagger.model.Device
import io.swagger.model.ServerInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class InMemoryDatabase(
        @Value("\${server.servlet.context-path}") val contextPath: String,
        @Value("\${server.port}") val port: String) : Database {
    private val devices = HashSet<Device>()

    override fun findAllDevices(): List<Device> = ArrayList(devices)


    override fun findDevice(id: Int): Optional<Device> =
            devices.stream()
                    .filter { d -> d.id == id }
                    .findAny()

    override fun addDevice(device: Device) {
        devices.add(device)
    }

    override fun findAllChannels(): List<Channel> =
            devices.stream()
                    .map { it.channels }
                    .flatMap { it.stream() }
                    .collect(Collectors.toList())

    override fun findChannel(id: Int): Optional<Channel> =
            findAllChannels()
                    .stream()
                    .filter { c -> c.id == id }
                    .findAny()

    override fun getServerInfo(): ServerInfo =
            ServerInfo()
                    .apiVersion("2.3.0")
                    .supportedApiVersions(listOf("2.3.0"))
                    .cloudVersion("2.3.0")
                    .address("http://localhost:$port$contextPath")
}