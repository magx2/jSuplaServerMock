package pl.grzeslowski.jsuplaservermock

import io.swagger.model.*
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.threeten.bp.OffsetDateTime
import pl.grzeslowski.jsuplaservermock.service.DeviceService
import java.lang.Math.max
import java.lang.Math.min
import java.lang.String.format
import java.math.BigDecimal
import java.math.RoundingMode.CEILING
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.collections.ArrayList


@Configuration
open class InitDb(private val deviceService: DeviceService) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(InitDb::class.java)
    private val maxId = 999
    private val random = Random(1337)
    private var updateChannelThreadPool = Executors.newScheduledThreadPool(5)

    override fun run(vararg args: String?) {
        val livingRoomLocation = buildLocation("Living Room")
        val bathroomLocation = buildLocation("Bathroom")
        listOf(
                buildLightDevice("ROW-01", 1).location(livingRoomLocation),
                buildLightDevice("ROW-02", 2),

                //power
                buildPowerDevice("Power Device", 1).location(livingRoomLocation),
                buildPowerDevice("Power Device", 2).location(bathroomLocation),
                buildPowerDevice("Power Device", 3).location(bathroomLocation),

                // rgb(w) / dimmer
                buildRgbDevice("RGB Controller").location(livingRoomLocation),
                buildDimmerAndRgbDevice("Dimmer and RGB").location(bathroomLocation),
                buildDimmerDevice("Dimmer").location(livingRoomLocation),

                // thermometer / humidity
                buildThermometerDevice("Balcony thermometer").location(livingRoomLocation),
                buildHumidityDevice("Bathroom humidity").location(bathroomLocation),
                buildThermometerAndHumidityDevice("Bedroom thermometer and humidity").location(livingRoomLocation),

                // roller shutter
                buldRollerShutterDevice("Roller shutter"),

                // gate and garage door
                buildGateDevice("SBW-01").location(bathroomLocation),
                buildGateDevice("SBW-01 Second").location(livingRoomLocation),
                buildGateDevice("SBW-01 Third"),

                // multiple channels
                buildDeviceWithMultipleChannels("Multiple channels #1"),
                buildDeviceWithMultipleChannels("Multiple channels #2")
        ).forEach {
            deviceService.addDevice(it)
            updateEnabled(it)
            updateName(it)
            updateComment(it)
        }
    }

    // ---------------
    // build locations
    // ---------------

    private fun buildLocation(caption: String): Location =
            Location()
                    .id(nextId())
                    .caption(caption)
                    .password("password:$caption")
                    .iodevices(ArrayList())

    // -------------
    // build devices
    // -------------

    private fun buildLightDevice(deviceName: String, numberOfChannels: Int): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = IntStream.range(0, numberOfChannels)
                .mapToObj { channelNumber -> buildLightChannel(channelNumber) }
                .collect(Collectors.toList())
        setChannelIds(device)
        return device
    }

    private fun buildPowerDevice(deviceName: String, numberOfChannels: Int): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = IntStream.range(0, numberOfChannels)
                .mapToObj { channelNumber -> buildPowerChannel(channelNumber) }
                .collect(Collectors.toList())
        setChannelIds(device)
        return device
    }

    private fun buildRgbDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildRgbChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buildDimmerAndRgbDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildDimmerAndRgbChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buildDimmerDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildDimmerChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buildThermometerDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildThermometerChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buildHumidityDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildHumidityChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buildThermometerAndHumidityDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = listOf(buildThermometerAndHumidityChannel(0))
        setChannelIds(device)
        return device
    }

    private fun buldRollerShutterDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        val rollerShutterChannel = buildRollerShutterChannel(0)
        val rollerShutterSensorChannel = buildRollerShutterSensorChannel(1, rollerShutterChannel.id)
        rollerShutterChannel.param2 = rollerShutterSensorChannel.id
        device.channels = listOf(rollerShutterChannel, rollerShutterSensorChannel)
        setChannelIds(device)
        return device
    }

    private fun buildGateDevice(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        val gateChannel = buildGateChannel(0)
        val sensor1Channel = buildGateSensorChannel(1, gateChannel.id)
        val sensor2Channel = buildGateSensorChannel(2, gateChannel.id)
        gateChannel.param2 = sensor1Channel.id
        gateChannel.param3 = sensor2Channel.id
        device.channels = listOf(gateChannel, sensor1Channel, sensor2Channel)
        setChannelIds(device)
        return device
    }

    @Suppress("UNUSED_CHANGED_VALUE")
    private fun buildDeviceWithMultipleChannels(deviceName: String): Device {
        val device = buildBasicDevice(deviceName)
        device.channels = ArrayList()
        var channelNumber = 0
        device.channels.add(buildLightChannel(channelNumber++))
        device.channels.add(buildLightChannel(channelNumber++))
        device.channels.add(buildRgbChannel(channelNumber++))
        device.channels.add(buildThermometerAndHumidityChannel(channelNumber++))
        return device
    }

    // --------------
    // build channels
    // --------------

    private fun buildLightChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Light channel type"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setOn(random.nextBoolean())
        channel.isHidden = false
        updateOnOffState(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Light channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.LIGHTSWITCH
        channel.function.caption = "Light channel #${channel.id}"

        return channel
    }

    private fun buildPowerChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Power channel type"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setOn(random.nextBoolean())
        channel.isHidden = false
        updateOnOffState(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Power channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.POWERSWITCH
        channel.function.caption = "Power channel #${channel.id}"

        return channel
    }

    private fun buildRgbChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setColor("0x00FF00").setColorBrightness(100)
        channel.isHidden = false
        updateRgbSchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RGBLEDCONTROLLER
        channel.type.caption = "RGB channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.RGBLIGHTING
        channel.function.caption = "RGB channel #${channel.id}"

        return channel
    }

    private fun buildDimmerAndRgbChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Dimmer and RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setColor("0x00FF00").setColorBrightness(100).setBrightness(100)
        channel.isHidden = false
        updateRgbSchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.DIMMERANDRGBLED
        channel.type.caption = "Dimmer and RGB channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.DIMMERANDRGBLIGHTING
        channel.function.caption = "Dimmer and RGB channel #${channel.id}"

        return channel
    }

    private fun buildDimmerChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Dimmer and RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setBrightness(random.nextInt(101))
        channel.isHidden = false
        updateRgbSchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.DIMMER
        channel.type.caption = "Dimmer and RGB channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.DIMMER
        channel.function.caption = "Dimmer and RGB channel #${channel.id}"

        return channel
    }

    private fun buildThermometerChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Thermometer channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setTemperature(BigDecimal(random.nextInt(80) - 30))
        channel.isHidden = false
        updateTemperatureSchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.THERMOMETER
        channel.type.caption = "Thermometer channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.THERMOMETER
        channel.function.caption = "Thermometer channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param2 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildHumidityChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Humidity channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setHumidity(BigDecimal(random.nextInt(101)))
        channel.isHidden = false
        updateHumiditySchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.HUMIDITYSENSOR
        channel.type.caption = "Humidity channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.HUMIDITY
        channel.function.caption = "Humidity channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param3 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildThermometerAndHumidityChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Humidity channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true)
                .setTemperature(BigDecimal(random.nextInt(80) - 30))
                .setHumidity(BigDecimal(random.nextInt(101)))
        channel.isHidden = false
        updateTemperatureSchedule(channel)
        updateHumiditySchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.HUMIDITYANDTEMPSENSOR
        channel.type.caption = "Thermometer and Humidity channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.HUMIDITYANDTEMPERATURE
        channel.function.caption = "Thermometer and Humidity channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param2 = random.nextInt(2000) - 1000
        channel.param3 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildRollerShutterChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Roller shutter channel"
        channel.channelNumber = channelNumber
        val shut = random.nextInt(101)
        channel.state = ChannelState().setConnected(true).setShut(shut).setHi(shut != 100).setCalibrating(false)
        channel.isHidden = false
        updateRollerShutterSchedule(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Roller shutter channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.CONTROLLINGTHEROLLERSHUTTER
        channel.function.caption = "Roller shutter channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = random.nextInt(3000)

        return channel
    }

    private fun buildRollerShutterSensorChannel(channelNumber: Int, rollerShutterId: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Roller shutter channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setHi(random.nextBoolean())
        channel.isHidden = false
        updateOnOffState(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.SENSORNC
        channel.type.caption = "Roller shutter channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.OPENINGSENSOR_ROLLERSHUTTER
        channel.function.caption = "Roller shutter channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = rollerShutterId

        return channel
    }

    private fun buildGateChannel(channelNumber: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Gate channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setHi(random.nextBoolean()).setPartialHi(random.nextBoolean())
        channel.isHidden = false
        updateGateState(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Gate channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.CONTROLLINGTHEGATE
        channel.function.caption = "Gate channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = random.nextInt(1_500) + 500

        return channel
    }

    private fun buildGateSensorChannel(channelNumber: Int, gateChannelId: Int): Channel {
        val channel = Channel().connected(true)

        channel.id = nextId()
        channel.caption = "Gate channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setConnected(true).setHi(random.nextBoolean())
        channel.isHidden = false
        updateOnOffState(channel)
        updateConnected(channel)
        updateCaption(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.SENSORNO
        channel.type.caption = "Gate channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.OPENINGSENSOR_GARAGEDOOR
        channel.function.caption = "Gate channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = gateChannelId

        return channel
    }

    private fun updateOnOffState(channel: Channel) {
        schedule {
            logger.debug("Changing on/off for channel {}", channel.id)
            val on = channel.state.on
            if (on != null) {
                channel.state.on = random.nextBoolean()
            }
            val hi = channel.state.hi
            if (hi != null) {
                channel.state.hi = random.nextBoolean()
            }
        }
    }

    private fun updateGateState(channel: Channel) {
        schedule {
            logger.debug("Changing gate position for channel {}", channel.id)
            val hi = channel.state.hi
            val partialHi = channel.state.partialHi
            if (partialHi != null && partialHi) { // partially opened
                channel.state.hi = hi.not()
            } else {
                val shouldStartOpeningClosingGate = random.nextBoolean()
                if (shouldStartOpeningClosingGate) {
                    channel.state.partialHi = true
                } else {
                    channel.state.hi = random.nextBoolean()
                }
            }
        }
    }

    private fun updateTemperatureSchedule(channel: Channel) {
        schedule {
            logger.debug("Changing temperature for channel {}", channel.id)
            val adjustment = BigDecimal(channel.param2).divide(BigDecimal(100), CEILING)
            channel.state.temperature = nearByNumber(
                    channel.state.temperature,
                    BigDecimal(-100).subtract(adjustment),
                    BigDecimal(100).subtract(adjustment))
        }
    }

    private fun updateHumiditySchedule(channel: Channel) {
        schedule {
            logger.debug("Changing humidity for channel {}", channel.id)
            val adjustment = BigDecimal(channel.param3).divide(BigDecimal(100), CEILING)
            channel.state.humidity = nearByNumber(
                    channel.state.humidity,
                    BigDecimal.ZERO.subtract(adjustment),
                    BigDecimal(100).subtract(adjustment))
        }
    }

    private fun updateRgbSchedule(channel: Channel) {
        schedule {
            logger.debug("Changing RGB+brightness for channel {}", channel.id)
            val red = toHex(random.nextInt(256))
            val green = toHex(random.nextInt(256))
            val blue = toHex(random.nextInt(256))
            if (channel.state.color != null) {
                channel.state.color = format("0x%s%s%s", red, green, blue)
            }
            val colorBrightness = channel.state.colorBrightness
            if (colorBrightness != null) {
                channel.state.colorBrightness = nearByNumber(colorBrightness, 0, 100)
            }
            val brightness = channel.state.brightness
            if (brightness != null) {
                channel.state.brightness = nearByNumber(brightness, 0, 100)
            }
        }
    }

    private fun updateRollerShutterSchedule(channel: Channel) {
        schedule {
            logger.debug("Changing Roller Shutter for channel {}", channel.id)
            channel.state.shut = nearByNumber(channel.state.shut, 0, 100)
            channel.state.hi = channel.state.shut != 100
        }
    }

    private fun updateConnected(channel: Channel) {
        schedule {
            val previouslyConnected = channel.isConnected
            channel.isConnected = random.nextInt(100) < 90
            if (previouslyConnected != channel.isConnected) {
                if (channel.isConnected) {
                    logger.debug("Connecting channel {}", channel.id)
                } else {
                    logger.debug("Disconnecting channel {}", channel.id)
                }
            }
        }
    }

    private fun updateEnabled(device: Device) {
        schedule {
            val previouslyEnabled = device.isEnabled
            device.isEnabled = random.nextInt(100) < 90
            if (previouslyEnabled != device.isEnabled) {
                if (device.isEnabled) {
                    logger.debug("Enabling device {}", device.id)
                } else {
                    logger.debug("Disabling device {}", device.id)
                }
            }
        }
    }

    private fun updateName(device: Device) {
        schedule {
            logger.debug("Changing name for device {}", device.id)
            device.name = nearByString(device.name)
        }
    }

    private fun updateComment(device: Device) {
        schedule {
            logger.debug("Changing comment for device {}", device.id)
            device.comment = nearByString(device.comment)
        }
    }

    private fun updateCaption(channel: Channel) {
        schedule {
            logger.debug("Changing caption for channel {}", channel.id)
            channel.caption = nearByString(channel.caption)
        }
    }

    private fun nearByString(string: String): String {
        val sb = StringBuilder()
        for (s in string) {
            sb.append(if (random.nextBoolean()) s.toUpperCase() else s.toLowerCase())
        }
        return sb.toString()
    }

    private fun nearByNumber(number: Double, min: Double, max: Double): Double {
        val minus = when (number) {
            min -> -1.0
            max -> 1.0
            else -> if (random.nextBoolean()) 1.0 else -1.0
        }
        val delta = if (number != 0.0) {
            number * random.nextDouble()
        } else {
            min + (max - min) * random.nextDouble()
        }
        val newNumber = number - delta * minus
        return max(min, min(max, newNumber))
    }

    private fun nearByNumber(number: Int, max: Int, min: Int): Int =
            nearByNumber(number.toDouble(), max.toDouble(), min.toDouble()).toInt()

    private fun nearByNumber(number: BigDecimal, max: BigDecimal, min: BigDecimal): BigDecimal =
            BigDecimal(nearByNumber(number.toDouble(), max.toDouble(), min.toDouble())).setScale(2, CEILING)

    private fun toHex(value: Int): String {
        val addZeroPrefix = value < 16
        val hex = Integer.toHexString(value).toUpperCase()
        return if (addZeroPrefix) "0$hex" else hex
    }

    private fun schedule(command: () -> Unit) {
        val random = Random()
        val delay: Long = (random.nextInt(10) + 10).toLong()
        updateChannelThreadPool.scheduleAtFixedRate(command, delay * 2, delay, TimeUnit.SECONDS)
    }

    private fun nextId() = random.nextInt(maxId)

    private fun nextRegDate() = OffsetDateTime.now().minusDays(random.nextInt(100).toLong())

    private fun nextGuid(): String {
        val bytes = ByteArray(16)
        random.nextBytes(bytes)
        return String.format("%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X",
                bytes[0],
                bytes[1],
                bytes[2],
                bytes[3],
                bytes[4],
                bytes[5],
                bytes[6],
                bytes[7],
                bytes[8],
                bytes[9],
                bytes[10],
                bytes[11],
                bytes[12],
                bytes[13],
                bytes[14],
                bytes[15]
        )
    }

    private fun buildBasicDevice(deviceName: String): Device {
        val device = Device()
        device.id = nextId()
        device.name = deviceName
        device.comment = "Comment to $deviceName"
        device.regDate = nextRegDate()
        device.lastConnected = OffsetDateTime.now()
        device.softwareVersion = "mock-server"
        device.guidString = nextGuid()
        device.isEnabled = true
        device.isConnected = true
        return device
    }

    private fun setChannelIds(device: Device) {
        device.channelsIds = device.channels.stream().map { it.id }.collect(Collectors.toList())
    }
}