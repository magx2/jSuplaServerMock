package pl.grzeslowski.jsuplaservermock.service;

import io.swagger.model.Channel;

import java.util.List;

public interface ChannelService {
    Channel getChannel(int id);

    List<Channel> getAllChannels();
}
