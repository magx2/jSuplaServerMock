package pl.grzeslowski.jsuplaservermock

import io.swagger.model.Channel
import io.swagger.model.Device
import io.swagger.model.Location
import io.swagger.model.ServerInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pl.grzeslowski.jsuplaservermock.service.*
import java.util.stream.Collectors

@Service
class InMemoryDatabase(@Value("\${server.servlet.context-path}") val contextPath: String,
                       @Value("\${server.port}") val port: String) : DeviceService, ServerService, ChannelService, LocationService {
    private val devices: MutableSet<Device> = HashSet()
    private val locations: MutableMap<Location, MutableList<Device>> = HashMap()

    override fun addDevice(device: Device) {
        val location = device.location
        if (location != null) {
            locations.putIfAbsent(location, ArrayList())
            locations[location]!!.add(device)
            location.iodevices = null
        }
        device.location = null
        devices.add(device)
    }

    override fun getDevice(id: Int) =
            devices.stream()
                    .filter { device -> device.id == id }
                    .findAny()
                    .orElseThrow { EntityNotFoundException(Device::class.java, id) }

    override fun getChannelsForDevice(id: Int): MutableList<Channel> = getDevice(id).channels

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

    override fun addLocation(location: Location) {
        locations[location] = ArrayList()
    }

    override fun deleteLocation(id: Int) {
        val it = locations.iterator()
        while (it.hasNext()) {
            val (location, _) = it.next()
            if (location.id == id) {
                it.remove()
            }
        }
    }

    override fun getLocation(id: Int): Location =
            locations.entries
                    .map { it.key }
                    .stream()
                    .filter { location -> location.id == id }
                    .findAny()
                    .orElseThrow { EntityNotFoundException(Location::class.java, id) }

    override fun getLocations(): MutableList<Location> =
            locations.entries
                    .map { (key, value) -> key.iodevices = value; key }
                    .stream()
                    .collect(Collectors.toList())
}
