package pl.grzeslowski.jsuplaservermock

import io.swagger.model.*
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.threeten.bp.OffsetDateTime
import pl.grzeslowski.jsuplaservermock.service.DeviceService
import java.math.BigDecimal
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import java.util.stream.IntStream


@Configuration
open class InitDb(private val deviceService: DeviceService) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(InitDb::class.java)
    private val maxId = 999
    private val random = Random(1337)
    private var updateChannelThreadPool = Executors.newScheduledThreadPool(5)

    override fun run(vararg args: String?) {
        listOf(
                buildLightDevice("ROW-01", 1),
                buildLightDevice("ROW-02", 2),

                //power
                buildPowerDevice("Power Device", 1),
                buildPowerDevice("Power Device", 2),
                buildPowerDevice("Power Device", 3),

                // rgb(w) / dimmer
                buildRgbDevice("RGB Controller"),
                buildDimmerAndRgbDevice("Dimmer and RGB"),
                buildDimmerDevice("Dimmer"),

                // thermometer / humidity
                buildThermometerDevice("Balcony thermometer"),
                buildHumidityDevice("Bathroom humidity"),
                buildThermometerAndHumidityDevice("Bedroom thermometer and humidity"),

                // roller shutter
                buldRollerShutterDevice("Roller shutter"),

                // gate and garage door
                buildGateDevice("SBW-01")
        ).forEach { deviceService.addDevice(it) }
    }

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

    // --------------
    // build channels
    // --------------

    private fun buildLightChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Light channel type"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setOn(random.nextBoolean())
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Light channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.LIGHTSWITCH
        channel.function.caption = "Light channel #${channel.id}"

        return channel
    }

    private fun buildPowerChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Power channel type"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setOn(random.nextBoolean())
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Power channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.POWERSWITCH
        channel.function.caption = "Power channel #${channel.id}"

        return channel
    }

    private fun buildRgbChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setColor("0xFF0000").setColorBrightness(100)
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RGBLEDCONTROLLER
        channel.type.caption = "RGB channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.RGBLIGHTING
        channel.function.caption = "RGB channel #${channel.id}"

        return channel
    }

    private fun buildDimmerAndRgbChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Dimmer and RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setColor("0xFF0000").setColorBrightness(100).setBrightness(100)
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.DIMMERANDRGBLED
        channel.type.caption = "Dimmer and RGB channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.DIMMERANDRGBLIGHTING
        channel.function.caption = "Dimmer and RGB channel #${channel.id}"

        return channel
    }

    private fun buildDimmerChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Dimmer and RGB channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setBrightness(random.nextInt(101))
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.DIMMER
        channel.type.caption = "Dimmer and RGB channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.DIMMER
        channel.function.caption = "Dimmer and RGB channel #${channel.id}"

        return channel
    }

    private fun buildThermometerChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Thermometer channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setTemperature(BigDecimal(random.nextInt(80) - 30))
        channel.isHidden = false
        updateTemperatureSchedule(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.THERMOMETER
        channel.type.caption = "Thermometer channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.THERMOMETER
        channel.function.caption = "Thermometer channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param2 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildHumidityChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Humidity channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setHumidity(BigDecimal(random.nextInt(101)))
        channel.isHidden = false
        updateHumiditySchedule(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.HUMIDITYSENSOR
        channel.type.caption = "Humidity channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.HUMIDITY
        channel.function.caption = "Humidity channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param3 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildThermometerAndHumidityChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Humidity channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState()
                .setTemperature(BigDecimal(random.nextInt(80) - 30))
                .setHumidity(BigDecimal(random.nextInt(101)))
        channel.isHidden = false
        updateTemperatureSchedule(channel)
        updateHumiditySchedule(channel)

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.HUMIDITYANDTEMPSENSOR
        channel.type.caption = "Humidity channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.HUMIDITYANDTEMPERATURE
        channel.function.caption = "Humidity channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param2 = random.nextInt(2000) - 1000
        channel.param3 = random.nextInt(2000) - 1000

        return channel
    }

    private fun buildRollerShutterChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Roller shutter channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setShut(random.nextInt(101))
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Roller shutter channel #${channel.id}"
        channel.type.isOutput = false

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.CONTROLLINGTHEROLLERSHUTTER
        channel.function.caption = "Roller shutter channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = random.nextInt(3000)

        return channel
    }

    private fun buildRollerShutterSensorChannel(channelNumber: Int, rollerShutterId: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Roller shutter channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setHi(random.nextBoolean())
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.SENSORNC
        channel.type.caption = "Roller shutter channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.OPENINGSENSOR_ROLLERSHUTTER
        channel.function.caption = "Roller shutter channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = rollerShutterId

        return channel
    }

    private fun buildGateChannel(channelNumber: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Gate channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setHi(random.nextBoolean())
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.RELAY
        channel.type.caption = "Gate channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.CONTROLLINGTHEGARAGEDOOR
        channel.function.caption = "Gate channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = random.nextInt(1_500) + 500

        return channel
    }

    private fun buildGateSensorChannel(channelNumber: Int, gateChannelId: Int): Channel {
        val channel = Channel()

        channel.id = nextId()
        channel.caption = "Gate channel"
        channel.channelNumber = channelNumber
        channel.state = ChannelState().setHi(random.nextBoolean())
        channel.isHidden = false

        channel.type = ChannelType()
        channel.type.name = ChannelType.NameEnum.SENSORNO
        channel.type.caption = "Gate channel #${channel.id}"
        channel.type.isOutput = true

        channel.function = ChannelFunction()
        channel.function.name = ChannelFunctionEnumNames.OPENINGSENSOR_GARAGEDOOR
        channel.function.caption = "Gate channel #${channel.id}"

        // https://github.com/SUPLA/supla-cloud/wiki/Channel-Functions-parameters
        channel.param1 = gateChannelId

        return channel
    }

    private fun updateTemperatureSchedule(channel: Channel) {
        schedule {
            logger.debug("Changing temperature for channel {}", channel.id)
            channel.state.temperature += BigDecimal(random.nextInt(200) - 100).divide(BigDecimal(10))
        }
    }

    private fun updateHumiditySchedule(channel: Channel) {
        schedule {
            logger.debug("Changing humidity for channel {}", channel.id)
            channel.state.temperature += BigDecimal(random.nextInt(200) - 100).divide(BigDecimal(10))
        }
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