package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CityResponse;
import org.example.dto.CountryResponse;
import org.example.dto.LocationResponse;
import org.example.dto.StreetResponse;
import org.example.exception.EntityNotFoundException;
import org.example.mapper.Mapper;
import org.example.model.City;
import org.example.model.Country;
import org.example.model.Street;
import org.example.repository.CityRepository;
import org.example.repository.CountryRepository;
import org.example.repository.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{

    private final StreetRepository streetRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    @Override
    public Optional<LocationResponse> getLocationById(UUID id) {
        Street street = streetRepository.findById(id).orElse(null);
        if(street == null)
            return Optional.empty();
        return Optional.of(Mapper.toLocationResponse(street));
    }

    @Override
    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll().stream()
                    .map(Mapper::toCountryResponse)
                    .collect(Collectors.toList());
    }

    @Override
    public List<CityResponse> getCitiesByCountryId(Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() ->new EntityNotFoundException(Country.class, "id", countryId.toString()));
        return  country.getCities().stream()
                    .map(Mapper::toCityResponse)
                    .collect(Collectors.toList());
    }

    @Override
    public List<StreetResponse> getStreetsForCountry(Long countryId, Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException(City.class, "id", cityId.toString()));
        if(!city.getCountry().getId().equals(countryId))
            throw new EntityNotFoundException("Location with country-id " + countryId + " and city-id " + cityId + " not found!");
        return city.getStreets().stream()
                    .map(Mapper::toStreetResponse)
                    .collect(Collectors.toList());
    }

}
