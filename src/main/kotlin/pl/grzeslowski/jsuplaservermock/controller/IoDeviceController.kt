package pl.grzeslowski.jsuplaservermock.controller

import io.swagger.api.IodevicesApi
import io.swagger.model.Channel
import io.swagger.model.Device
import io.swagger.model.IODeviceUpdateRequest
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import pl.grzeslowski.jsuplaservermock.service.DeviceService

@RestController
class IoDeviceController(private val deviceService: DeviceService) : IodevicesApi {
    override fun deleteIoDevice(id: Int): ResponseEntity<Void> {
        deviceService.deleteDevice(id)
        return ResponseEntity(NO_CONTENT)
    }

    override fun getIoDevice(id: Int, include: List<String>?) = ResponseEntity.ok(deviceService.getDevice(id))

    override fun getIoDeviceChannels(id: Int, include: List<String>?): ResponseEntity<List<Channel>> =
            ResponseEntity.ok(deviceService.getChannelsForDevice(id))

    override fun getIoDevices(include: List<String>?) = ResponseEntity.ok(deviceService.allDevices)

    override fun updateIoDevice(body: IODeviceUpdateRequest, id: Int): ResponseEntity<Device> {
        var device: Device? = null
        if (body.comment != null) {
            device = deviceService.changeDeviceComment(id, body.comment)
        }
        if (body.isEnabled != null) {
            device = deviceService.changeDeviceEnabled(id, body.isEnabled)
        }
        if (body.locationId != null) {
            device = deviceService.changeDeviceLocationId(id, body.locationId)
        }
        return if (device != null) {
            ResponseEntity.ok(device)
        } else {
            ResponseEntity.badRequest().build()
        }
    }
}
