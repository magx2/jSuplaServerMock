package pl.grzeslowski.jsuplaservermock.controller;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import io.swagger.model.Channel;
import io.swagger.model.ChannelExecuteActionRequest;
import io.swagger.model.ChannelFunctionActionEnum;
import io.swagger.model.ChannelFunctionEnumNames;
import io.swagger.model.ChannelUpdateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.grzeslowski.jsuplaservermock.service.ChannelService;

import java.util.ArrayList;
import java.util.List;

import static io.swagger.model.ChannelFunctionActionEnum.CLOSE;
import static io.swagger.model.ChannelFunctionActionEnum.OPEN;
import static io.swagger.model.ChannelFunctionActionEnum.OPEN_CLOSE;
import static io.swagger.model.ChannelFunctionActionEnum.REVEAL;
import static io.swagger.model.ChannelFunctionActionEnum.SET_RGBW_PARAMETERS;
import static io.swagger.model.ChannelFunctionActionEnum.SHUT;
import static io.swagger.model.ChannelFunctionActionEnum.STOP;
import static io.swagger.model.ChannelFunctionActionEnum.TURN_OFF;
import static io.swagger.model.ChannelFunctionActionEnum.TURN_ON;
import static io.swagger.model.ChannelFunctionEnumNames.CONTROLLINGTHEDOORLOCK;
import static io.swagger.model.ChannelFunctionEnumNames.CONTROLLINGTHEGARAGEDOOR;
import static io.swagger.model.ChannelFunctionEnumNames.CONTROLLINGTHEGATE;
import static io.swagger.model.ChannelFunctionEnumNames.CONTROLLINGTHEROLLERSHUTTER;
import static io.swagger.model.ChannelFunctionEnumNames.DIMMER;
import static io.swagger.model.ChannelFunctionEnumNames.DIMMERANDRGBLIGHTING;
import static io.swagger.model.ChannelFunctionEnumNames.LIGHTSWITCH;
import static io.swagger.model.ChannelFunctionEnumNames.POWERSWITCH;
import static io.swagger.model.ChannelFunctionEnumNames.RGBLIGHTING;
import static io.swagger.model.ChannelFunctionEnumNames.STAIRCASETIMER;
import static java.lang.Math.abs;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SuppressWarnings("WeakerAccess")
@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBeansExtension.class)
class ChannelControllerTest {
    @InjectMocks ChannelController controller;
    @Mock ChannelService channelService;

    @Random(excludes = {"iodevice", "location"}) Channel channel;
    @Random(type = Channel.class, excludes = {"iodevice", "location"}) List<Channel> channels;
    @Random int justRandomInt;

    @Test
    @DisplayName("should get channel")
    void getChannel() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);

        // when
        final ResponseEntity<Channel> response = controller.getChannel(this.channel.getId(), null);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        assertThat(response.getBody()).isEqualTo(channel);
    }

    @Test
    @DisplayName("should get all channels without any filters")
    void getChannels() {
        // given
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, null, null, null);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        assertThat(response.getBody()).isEqualTo(channels);
    }

    @Test
    @DisplayName("should get only `input` channels")
    void getChannelsInput() {
        // given
        prepareChannelsForIO();
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, null, "input", null);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        List<Channel> inputChannels = response.getBody();
        assertThat(inputChannels).isNotNull();
        inputChannels.forEach(channel ->
                                      assertThat(channel.getType().isOutput())
                                              .as(channel.toString())
                                              .isTrue());
    }

    @Test
    @DisplayName("should get only `output` channels")
    void getChannelsOutput() {
        // given
        prepareChannelsForIO();
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, null, "output", null);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        List<Channel> inputChannels = response.getBody();
        assertThat(inputChannels).isNotNull();
        inputChannels.forEach(channel ->
                                      assertThat(channel.getType().isOutput())
                                              .as(channel.toString())
                                              .isFalse());
    }

    private void prepareChannelsForIO() {
        for (int i = 0; i < channels.size(); i++) {
            final int b = i % 3;
            final Boolean output;
            if (b == 0) {
                output = true;
            } else if (b == 1) {
                output = false;
            } else {
                output = null;
            }
            channels.get(i).getType().output(output);
        }
    }

    @Test
    @DisplayName("should get only channels with functions")
    void getChannelsChannelFunctionEnumNames(@Random(type = ChannelFunctionEnumNames.class) List<ChannelFunctionEnumNames> channelFunctionEnumNames) {
        // given
        prepareChannelsForFunctions(channelFunctionEnumNames);
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, channelFunctionEnumNames, null, null);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        List<Channel> inputChannels = response.getBody();
        assertThat(inputChannels).isNotNull();
        inputChannels.forEach(channel ->
                                      assertThat(channel.getFunction().getName())
                                              .as(channel.toString())
                                              .isIn(channelFunctionEnumNames));
    }

    @Test
    @DisplayName("should get only channels with functions (has function = true)")
    void getChannelsChannelFunctionEnumNamesTrue(@Random(type = ChannelFunctionEnumNames.class) List<ChannelFunctionEnumNames> channelFunctionEnumNames) {
        // given
        prepareChannelsForFunctions(channelFunctionEnumNames);
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, channelFunctionEnumNames, null, true);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        List<Channel> inputChannels = response.getBody();
        assertThat(inputChannels).isNotNull();
        inputChannels.forEach(channel ->
                                      assertThat(channel.getFunction().getName())
                                              .as(channel.toString())
                                              .isIn(channelFunctionEnumNames));
    }

    @Test
    @DisplayName("should get only channels without functions")
    void getChannelsChannelFunctionEnumNamesFalse(@Random(type = ChannelFunctionEnumNames.class) List<ChannelFunctionEnumNames> channelFunctionEnumNames) {
        // given
        prepareChannelsForFunctions(channelFunctionEnumNames);
        given(channelService.getAllChannels()).willReturn(channels);

        // when
        final ResponseEntity<List<Channel>> response = controller.getChannels(null, channelFunctionEnumNames, null, false);

        // then
        assertThat(response.getStatusCode().is2xxSuccessful())
                .as(response.toString())
                .isTrue();
        List<Channel> inputChannels = response.getBody();
        assertThat(inputChannels).isNotNull();
        inputChannels.forEach(channel ->
                                      assertThat(channel.getFunction().getName())
                                              .as(channel.toString())
                                              .isNotIn(channelFunctionEnumNames));
    }

    private void prepareChannelsForFunctions(List<ChannelFunctionEnumNames> channelFunctionEnumNames) {
        for (int i = 0; i < channels.size(); i++) {
            if (i % 2 == 0) {
                ChannelFunctionEnumNames channelFunctionEnumName = channelFunctionEnumNames.get(i % channelFunctionEnumNames.size());
                channels.get(i).getFunction().name(channelFunctionEnumName);
            }
        }
    }

    @Test
    @DisplayName("should update channel")
    void updateChannel(@Random ChannelUpdateRequest updateRequest) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);

        // when
        ResponseEntity<Channel> response = controller.updateChannel(updateRequest, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();

        assertThat(channel.getFunctionId()).isEqualTo(updateRequest.getFunctionId());
        assertThat(channel.getParam1()).isEqualTo(updateRequest.getParam1());
        assertThat(channel.getParam2()).isEqualTo(updateRequest.getParam2());
        assertThat(channel.getParam3()).isEqualTo(updateRequest.getParam3());
        assertThat(channel.getParam1()).isEqualTo(updateRequest.getParam1());
        assertThat(channel.getParam2()).isEqualTo(updateRequest.getParam2());
        assertThat(channel.getParam3()).isEqualTo(updateRequest.getParam3());
        assertThat(channel.getCaption()).isEqualTo(updateRequest.getCaption());
        assertThat(channel.getAltIcon()).isEqualTo(updateRequest.getAltIcon());
        assertThat(channel.isHidden()).isEqualTo(updateRequest.isHidden());
        assertThat(channel.getLocationId()).isEqualTo(updateRequest.getLocationId());
        assertThat(channel.isInheritedLocation()).isEqualTo(updateRequest.isInheritedLocation());
        assertThat(channel.getUserIconId()).isEqualTo(updateRequest.getUserIconId());
    }

    @Test
    @DisplayName("should execute OPEN action")
    void executeActionOpen() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEDOORLOCK);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN);
        channel.setParam2(null);
        channel.setParam3(null);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isTrue();
    }

    @SuppressWarnings("Duplicates")
    @ParameterizedTest
    @ValueSource(strings = {"OPEN", "CLOSE"})
    @DisplayName("should not execute OPEN and CLOSE action")
    void executeActionOpenAndCloseWrongDevice(String functionName) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(randomFunction(CONTROLLINGTHEDOORLOCK));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(ChannelFunctionActionEnum.valueOf(functionName));

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should execute CLOSE action")
    void executeActionClose() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.setParam2(null);
        channel.setParam3(null);
        channel.getFunction().name(CONTROLLINGTHEDOORLOCK);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isFalse();
    }

    @Test
    @DisplayName("should execute full SHUT action")
    void executeActionFullShut() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEROLLERSHUTTER);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(SHUT).percentage(null);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getShut())
                .as(channel.getState().toString())
                .isEqualTo(100);
    }

    @Test
    @DisplayName("should execute partial SHUT action")
    void executeActionPartialShut() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEROLLERSHUTTER);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(SHUT).percentage(69);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getShut())
                .as(channel.getState().toString())
                .isEqualTo(69);
    }

    @Test
    @DisplayName("should execute full REVEAL action")
    void executeActionFullReveal() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEROLLERSHUTTER);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(REVEAL).percentage(null);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getShut())
                .as(channel.getState().toString())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("should execute partial REVEAL action")
    void executeActionPartialReveal() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEROLLERSHUTTER);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(REVEAL).percentage(69);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getShut())
                .as(channel.getState().toString())
                .isEqualTo(100 - 69);
    }

    @Test
    @DisplayName("should execute full REVEAL action")
    void executeActionStop() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(CONTROLLINGTHEROLLERSHUTTER);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(STOP);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
    }

    @SuppressWarnings("Duplicates")
    @ParameterizedTest
    @ValueSource(strings = {"SHUT", "REVEAL", "STOP"})
    @DisplayName("should not execute SHUT and REVEAL action")
    void executeActionShutAndRevealWrongDevice(String functionName) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(randomFunction(CONTROLLINGTHEROLLERSHUTTER));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(ChannelFunctionActionEnum.valueOf(functionName));

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @ParameterizedTest
    @ValueSource(strings = {"POWERSWITCH", "LIGHTSWITCH", "STAIRCASETIMER"})
    @DisplayName("should execute TURN_ON action")
    void executeActionTurnOn(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(TURN_ON);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getOn())
                .as(channel.getState().toString())
                .isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"POWERSWITCH", "LIGHTSWITCH", "STAIRCASETIMER"})
    @DisplayName("should execute TURN_OFF action")
    void executeActionTurnOff(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(TURN_OFF);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getOn())
                .as(channel.getState().toString())
                .isEqualTo(false);
    }

    @SuppressWarnings("Duplicates")
    @ParameterizedTest
    @ValueSource(strings = {"TURN_ON", "TURN_OFF"})
    @DisplayName("should not execute TURN_ON and TURN_OFF action")
    void executeActionTurnOnAndTurnOffWrongDevice(String functionName) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(randomFunction(POWERSWITCH, LIGHTSWITCH, STAIRCASETIMER));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(ChannelFunctionActionEnum.valueOf(functionName));

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONTROLLINGTHEGARAGEDOOR", "CONTROLLINGTHEGATE"})
    @DisplayName("should execute OPEN_CLOSE action when channel state is OPEN")
    void executeActionOpenCloseTrue(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        channel.getState().setHi(false).setPartialHi(false);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
        assertThat(channel.getState().getPartialHi())
                .as(channel.getState().toString())
                .isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONTROLLINGTHEGARAGEDOOR", "CONTROLLINGTHEGATE"})
    @DisplayName("should execute OPEN_CLOSE action when channel state is PARTIALLY OPEN (was CLOSED)")
    void executeActionOpenClosePartiallyOpen1(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        channel.getState().setHi(false).setPartialHi(true).setCalibrating(true);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
        assertThat(channel.getState().getPartialHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONTROLLINGTHEGARAGEDOOR", "CONTROLLINGTHEGATE"})
    @DisplayName("should execute OPEN_CLOSE action when channel state is PARTIALLY OPEN (was OPEN)")
    void executeActionOpenClosePartiallyOpen2(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        channel.getState().setHi(false).setPartialHi(true).setCalibrating(false);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isEqualTo(true);
        assertThat(channel.getState().getPartialHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONTROLLINGTHEGARAGEDOOR", "CONTROLLINGTHEGATE"})
    @DisplayName("should execute OPEN_CLOSE action when channel state is CLOSE#1")
    void executeActionOpenCloseFalse1(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        channel.getState().setHi(true).setPartialHi(false);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
        assertThat(channel.getState().getPartialHi())
                .as(channel.getState().toString())
                .isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CONTROLLINGTHEGARAGEDOOR", "CONTROLLINGTHEGATE"})
    @DisplayName("should execute OPEN_CLOSE action when channel state is CLOSE#2")
    void executeActionOpenCloseFalse2(String channelFunction) {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(ChannelFunctionEnumNames.valueOf(channelFunction));
        channel.getState().setHi(true).setPartialHi(true);
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getHi())
                .as(channel.getState().toString())
                .isEqualTo(false);
        assertThat(channel.getState().getPartialHi())
                .as(channel.getState().toString())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("should not execute TURN_ON and TURN_OFF action")
    void executeActionOpenCloseWrongDevice() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(randomFunction(CONTROLLINGTHEGARAGEDOOR, CONTROLLINGTHEGATE));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(OPEN_CLOSE);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should execute SET_RGBW_PARAMETERS action on RGBLIGHTING")
    void executeActionSetRgbwRgbLightning() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(RGBLIGHTING);
        final String color = "0xFF00FF";
        final int colorBrightness = 69;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getColor())
                .as(channel.getState().toString())
                .isEqualTo(color);
        assertThat(channel.getState().getColorBrightness())
                .as(channel.getState().toString())
                .isEqualTo(colorBrightness);
        assertThat(channel.getState().getBrightness())
                .as(channel.getState().toString())
                .isEqualTo(null);
    }

    @Test
    @DisplayName("should execute SET_RGBW_PARAMETERS action on DIMMERANDRGBLIGHTING")
    void executeActionSetRgbwDimmerAndRgbLightning() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMERANDRGBLIGHTING);
        final String color = "0xFF00FF";
        final int colorBrightness = 69;
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getColor())
                .as(channel.getState().toString())
                .isEqualTo(color);
        assertThat(channel.getState().getColorBrightness())
                .as(channel.getState().toString())
                .isEqualTo(colorBrightness);
        assertThat(channel.getState().getBrightness())
                .as(channel.getState().toString())
                .isEqualTo(brightness);
    }

    @Test
    @DisplayName("should execute SET_RGBW_PARAMETERS action on DIMMERANDRGBLIGHTING")
    void executeActionSetRgbwDimmer() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMER);
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode().is2xxSuccessful()).as(response.toString()).isTrue();
        assertThat(channel.getState().getColor())
                .as(channel.getState().toString())
                .isEqualTo(null);
        assertThat(channel.getState().getColorBrightness())
                .as(channel.getState().toString())
                .isEqualTo(null);
        assertThat(channel.getState().getBrightness())
                .as(channel.getState().toString())
                .isEqualTo(brightness);
    }

    @Test
    @DisplayName("should return 400 when set brightness on RGBLIGHTING")
    void executeActionSetRgbwRgbLightning400() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(RGBLIGHTING);
        final String color = "0xFF00FF";
        final int colorBrightness = 69;
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when set color on DIMMER")
    void executeActionSetRgbwDimmerColor400() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMER);
        final String color = "0xFF00FF";
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when set color brightness on DIMMER")
    void executeActionSetRgbwDimmerColorBrightnes400() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMER);
        final int colorBrightness = 69;
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when color is missing for DIMMERANDRGBLIGHTING")
    void executeActionSetRgbwDimmerAndRgbLightningMissingColor() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMERANDRGBLIGHTING);
        final String color = null;
        final int colorBrightness = 69;
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when color brightness is missing for DIMMERANDRGBLIGHTING")
    void executeActionSetRgbwDimmerAndRgbLightningMissingColorBrightness() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMERANDRGBLIGHTING);
        final String color = "0xFF00FF";
        final Integer colorBrightness = null;
        final int brightness = 13;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when brightness is missing for DIMMERANDRGBLIGHTING")
    void executeActionSetRgbwDimmerAndRgbLightningMissingBrightness() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMERANDRGBLIGHTING);
        final String color = "0xFF00FF";
        final int colorBrightness = 69;
        final Integer brightness = null;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when color is missing for RGBLIGHTING")
    void executeActionSetRgbwRgbLightningMissingColor() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(RGBLIGHTING);
        final String color = null;
        final int colorBrightness = 69;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when color brightness is missing for RGBLIGHTING")
    void executeActionSetRgbwRgbLightningMissingColorBrightness() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(RGBLIGHTING);
        final String color = "0xFF00FF";
        final Integer colorBrightness = null;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .color(color)
                                                      .colorBrightness(colorBrightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should return 400 when brightness is missing for DIMMER")
    void executeActionSetRgbwDimmerMissingColorBrightness() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(DIMMER);
        final Integer brightness = null;
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest()
                                                      .action(SET_RGBW_PARAMETERS)
                                                      .brightness(brightness);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("should not execute SET_RGBW_PARAMETERS action")
    void executeActionSetRgbwWrongDevice() {
        // given
        given(channelService.getChannel(channel.getId())).willReturn(channel);
        channel.getFunction().name(randomFunction(RGBLIGHTING, DIMMERANDRGBLIGHTING, DIMMER));
        ChannelExecuteActionRequest request = new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS);

        // when
        ResponseEntity<Void> response = controller.executeAction(request, channel.getId());

        // then
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    ChannelFunctionEnumNames randomFunction(ChannelFunctionEnumNames... exclude) {
        List<ChannelFunctionEnumNames> functions = new ArrayList<>(asList(ChannelFunctionEnumNames.values()));
        functions.removeAll(asList(exclude));
        return functions.get(abs(justRandomInt) % functions.size());
    }
}
