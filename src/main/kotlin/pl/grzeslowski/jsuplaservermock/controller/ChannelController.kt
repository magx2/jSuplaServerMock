package pl.grzeslowski.jsuplaservermock.controller

import io.swagger.api.ChannelsApi
import io.swagger.model.*
import io.swagger.model.ChannelFunctionEnumNames.*
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_IMPLEMENTED
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Controller
import pl.grzeslowski.jsuplaservermock.service.ChannelService
import java.util.stream.Collectors

@Controller
class ChannelController(val channelService: ChannelService) : ChannelsApi {
    private val logger = LoggerFactory.getLogger(ChannelController::class.java)
    override fun executeAction(body: ChannelExecuteActionRequest, id: Int): ResponseEntity<Void> {
        val channel = channelService.getChannel(id)
        logger.info("Changing state for `{}` to:\n{}", channel.id, body)
        return when (body.action) {
            ChannelFunctionActionEnum.OPEN -> actionOpenOrClose(channel, true)
            ChannelFunctionActionEnum.CLOSE -> actionOpenOrClose(channel, false)
            ChannelFunctionActionEnum.SHUT -> actionRevealOrShut(channel, body.percentage ?: 100)
            ChannelFunctionActionEnum.REVEAL -> actionRevealOrShut(channel, 100 - (body.percentage ?: 100))
            ChannelFunctionActionEnum.REVEAL_PARTIALLY -> actionRevealOrShut(channel, body.percentage)
            ChannelFunctionActionEnum.TURN_ON -> actionTurnOnOrTurnOff(channel, true)
            ChannelFunctionActionEnum.TURN_OFF -> actionTurnOnOrTurnOff(channel, false)
            ChannelFunctionActionEnum.OPEN_CLOSE -> actionOpenClose(channel)
            ChannelFunctionActionEnum.STOP -> actionStop(channel)
            ChannelFunctionActionEnum.SET_RGBW_PARAMETERS -> actionRgbw(channel, body.color, body.colorBrightness, body.brightness)
            else -> ResponseEntity(NOT_IMPLEMENTED)
        }
    }

    private fun actionOpenOrClose(channel: Channel, state: Boolean): ResponseEntity<Void> {
        if (channel.function.name != CONTROLLINGTHEDOORLOCK) {
            val action = if (state) "OPEN" else "CLOSE"
            logger.warn("Cannot do action {} for {}; channel = {}", action, channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        channel.state.hi = state
        return ok().build()
    }

    private fun actionRevealOrShut(channel: Channel, shut: Int): ResponseEntity<Void> {
        if (channel.function.name != CONTROLLINGTHEROLLERSHUTTER) {
            logger.warn("Cannot do action SHUT/REVEAL({}) for {}; channel = {}", shut, channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        channel.state.shut = shut
        return ok().build()
    }

    private fun actionStop(channel: Channel): ResponseEntity<Void> {
        if (channel.function.name != CONTROLLINGTHEROLLERSHUTTER) {
            logger.warn("Cannot do action STOP for {}; channel = {}", channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        return ok().build()
    }

    private fun actionTurnOnOrTurnOff(channel: Channel, on: Boolean): ResponseEntity<Void> {
        val acceptedChannelFunctions = listOf(POWERSWITCH, LIGHTSWITCH, STAIRCASETIMER)
        if (acceptedChannelFunctions.contains(channel.function.name).not()) {
            logger.warn("Cannot do action TURN_ON/TURN_OFF for {}; channel = {}", channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        channel.state.on = on
        return ok().build()
    }

    private fun actionOpenClose(channel: Channel): ResponseEntity<Void> {
        val acceptedChannelFunctions = listOf(CONTROLLINGTHEGARAGEDOOR, CONTROLLINGTHEGATE)
        if (acceptedChannelFunctions.contains(channel.function.name).not()) {
            logger.warn("Cannot do action OPEN_CLOSE for {}; channel = {}", channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        channel.state.hi = channel.state.hi.not()
        return ok().build()
    }

    private fun actionRgbw(channel: Channel, color: String?, colorBrightness: Int?, brightness: Int?): ResponseEntity<Void> {
        if (channel.function.name == RGBLIGHTING) {
            if (color == null) {
                logger.warn("Missing color parameter for RGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (colorBrightness == null) {
                logger.warn("Missing colorBrightness parameter for RGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (brightness != null) {
                logger.warn("Cannot set brightness on RGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
        } else if (channel.function.name == DIMMERANDRGBLIGHTING) {
            if (color == null) {
                logger.warn("Missing color parameter for DIMMERANDRGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (colorBrightness == null) {
                logger.warn("Missing colorBrightness parameter for DIMMERANDRGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (brightness == null) {
                logger.warn("Missing brightness parameter for DIMMERANDRGBLIGHTING; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
        } else if (channel.function.name == DIMMER) {
            if (color != null) {
                logger.warn("Cannot set color on DIMMER; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (colorBrightness != null) {
                logger.warn("Cannot set color brightness on DIMMER; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
            if (brightness == null) {
                logger.warn("Missing brightness parameter for DIMMER; channel = {}", channel)
                return ResponseEntity(BAD_REQUEST)
            }
        } else {
            logger.warn("Cannot do action SET_RGBW_PARAMETERS for {}; channel = {}", channel.function.name, channel)
            return ResponseEntity(BAD_REQUEST)
        }
        channel.state.color = color
        channel.state.colorBrightness = colorBrightness
        channel.state.brightness = brightness
        return ok().build()
    }

    override fun getChannel(id: Int, include: MutableList<String>?) = ok(channelService.getChannel(id))

    override fun getChannelMeasurementLogs(id: Int, limit: Int, offset: Int) = ResponseEntity<List<ChannelMeasurementLog>>(NOT_IMPLEMENTED)

    override fun getChannelMeasurementLogsCsvFile(id: Int) = ResponseEntity<Void>(NOT_IMPLEMENTED)

    override fun getChannelSchedules(id: Int, include: MutableList<String>?) = ResponseEntity<List<Schedule>>(NOT_IMPLEMENTED)

    override fun getChannels(include: MutableList<String>?, function: MutableList<ChannelFunctionEnumNames>?, io: String?, hasFunction: Boolean?): ResponseEntity<MutableList<Channel>> {
        var allChannels = channelService.allChannels.stream()
        if ("input".equals(io)) {
            allChannels = allChannels
                    .filter { channel -> channel.type.isOutput != null }
                    .filter { channel -> channel.type.isOutput }
        } else if ("output".equals(io)) {
            allChannels = allChannels
                    .filter { channel -> channel.type.isOutput != null }
                    .filter { channel -> channel.type.isOutput.not() }
        }
        if (function != null && function.isNotEmpty()) {
            if (hasFunction != null && hasFunction == false) {
                allChannels = allChannels.filter { channel -> function.contains(channel.function.name).not() }
            } else {
                allChannels = allChannels.filter { channel -> function.contains(channel.function.name) }
            }
        }
        return ok(allChannels.collect(Collectors.toList()))
    }

    override fun updateChannel(body: ChannelUpdateRequest, id: Int): ResponseEntity<Channel> {
        val channel = channelService.getChannel(id)
        if (body.functionId != null) {
            channel.functionId = body.functionId
        }
        if (body.param1 != null) {
            channel.param1 = body.param1
        }
        if (body.param2 != null) {
            channel.param2 = body.param2
        }
        if (body.param3 != null) {
            channel.param3 = body.param3
        }
        if (body.textParam1 != null) {
            channel.textParam1 = body.textParam1
        }
        if (body.textParam2 != null) {
            channel.textParam2 = body.textParam2
        }
        if (body.textParam3 != null) {
            channel.textParam3 = body.textParam3
        }
        if (body.caption != null) {
            channel.caption = body.caption
        }
        if (body.altIcon != null) {
            channel.altIcon = body.altIcon
        }
        if (body.isHidden != null) {
            channel.isHidden = body.isHidden
        }
        if (body.locationId != null) {
            // TODO Note: During change locationId it should be also changed channel.location
            channel.locationId = body.locationId
        }
        if (body.isInheritedLocation != null) {
            channel.isInheritedLocation = body.isInheritedLocation
        }
        if (body.userIconId != null) {
            channel.userIconId = body.userIconId
        }
        return ok(channel)
    }
}