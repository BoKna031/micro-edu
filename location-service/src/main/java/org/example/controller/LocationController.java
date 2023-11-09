package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CityResponse;
import org.example.dto.CountryResponse;
import org.example.dto.LocationResponse;
import org.example.dto.StreetResponse;
import org.example.exception.EntityNotFoundException;
import org.example.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("rest/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getLocation(@PathVariable UUID id){
        Optional<LocationResponse> locationResponse =  locationService.getLocationById(id);
        if(locationResponse.isEmpty())
            throw new EntityNotFoundException("Location", "id", id.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationResponse.get());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryResponse>> getAllCountries(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.getAllCountries());
    }

    @GetMapping("/countries/{id}/cities")
    public ResponseEntity<List<CityResponse>> getCitiesByCountryId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.getCitiesByCountryId(id));
    }

    @GetMapping("/countries/{country-id}/cities/{city-id}/streets")
    public ResponseEntity<List<StreetResponse>> getStreetsForCountry(@PathVariable("country-id") Long countryId, @PathVariable("city-id") Long cityId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.getStreetsForCountry(countryId, cityId));
    }


}


