package pl.grzeslowski.jsuplaservermock.service;

import io.swagger.model.Location;

import java.util.List;

public interface LocationService {
    void addLocation(Location location);

    void deleteLocation(int id);

    Location getLocation(int id);

    List<Location> getLocations();
}
