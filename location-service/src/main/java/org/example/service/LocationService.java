package org.example.service;

import org.example.dto.CityResponse;
import org.example.dto.CountryResponse;
import org.example.dto.LocationResponse;
import org.example.dto.StreetResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocationService {
    Optional<LocationResponse> getLocationById(UUID id);
    List<CountryResponse> getAllCountries();
    List<CityResponse> getCitiesByCountryId(Long countryId);
    List<StreetResponse> getStreetsForCountry(Long countryId, Long cityId);

}
