package pl.grzeslowski.jsuplaservermock.controller

import io.swagger.api.LocationsApi
import io.swagger.model.Location
import io.swagger.model.LocationUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import pl.grzeslowski.jsuplaservermock.service.LocationService

@RestController
class LocationController(private val locationService: LocationService) : LocationsApi {
    override fun createLocation(): ResponseEntity<Location> =
            ResponseEntity(HttpStatus.NOT_IMPLEMENTED) // Create location does not have body!

    override fun deleteLocation(id: Int, include: MutableList<String>?): ResponseEntity<Void> {
        locationService.deleteLocation(id)
        return ResponseEntity(NO_CONTENT)
    }

    override fun getLocation(id: Int, include: MutableList<String>?): ResponseEntity<Location> =
            ResponseEntity.ok(locationService.getLocation(id))

    override fun getLocations(include: MutableList<String>?): ResponseEntity<MutableList<Location>> =
            ResponseEntity.ok(locationService.locations)

    override fun updateLocation(body: LocationUpdateRequest?, id: Int?, include: MutableList<String>?): ResponseEntity<Location> =
            ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
}