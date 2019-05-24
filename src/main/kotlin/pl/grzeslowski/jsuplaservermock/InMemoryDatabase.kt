package pl.grzeslowski.jsuplaservermock

import io.swagger.model.Channel
import io.swagger.model.Device
import io.swagger.model.ServerInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pl.grzeslowski.jsuplaservermock.service.ChannelService
import pl.grzeslowski.jsuplaservermock.service.DeviceService
import pl.grzeslowski.jsuplaservermock.service.EntityNotFoundException
import pl.grzeslowski.jsuplaservermock.service.ServerService
import java.util.stream.Collectors

@Service
class InMemoryDatabase(@Value("\${server.servlet.context-path}") val contextPath: String,
                       @Value("\${server.port}") val port: String) : DeviceService, ServerService, ChannelService {
    private val devices: MutableSet<Device> = HashSet()

    override fun addDevice(device: Device) {
        devices.add(device)
    }

    override fun getDevice(id: Int) =
            devices.stream()
                    .filter { device -> device.id == id }
                    .findAny()
                    .orElseThrow { EntityNotFoundException(Device::class.java, id) }

    override fun getAllDevices(): MutableList<Device> =
            devices.stream().collect(Collectors.toList())

    override fun changeDeviceComment(id: Int, comment: String): Device {
        val device = getDevice(id)
        device.comment = comment
        return device
    }

    override fun changeDeviceEnabled(id: Int, enabled: Boolean): Device {
        val device = getDevice(id)
        device.isEnabled = enabled
        return device
    }

    override fun changeDeviceLocationId(id: Int, locationId: Int): Device {
        val device = getDevice(id)
        device.locationId = locationId
        return device
    }

    override fun deleteDevice(id: Int) {
        devices.remove(getDevice(id))
    }

    override fun getServerInfo(): ServerInfo =
            ServerInfo()
                    .apiVersion("2.3.0")
                    .supportedApiVersions(listOf("2.3.0"))
                    .cloudVersion("2.3.0")
                    .address("http://localhost:$port$contextPath")

    override fun getChannel(id: Int) =
            devices.stream()
                    .map { it.channels }
                    .flatMap { it.stream() }
                    .filter { it.id == id }
                    .findAny()
                    .orElseThrow { EntityNotFoundException(Channel::class.java, id) }

    override fun getAllChannels() =
            devices.stream()
                    .map { it.channels }
                    .flatMap { it.stream() }
                    .collect(Collectors.toList())
}
