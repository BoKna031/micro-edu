package org.example.mapper;

import org.example.dto.CityResponse;
import org.example.dto.CountryResponse;
import org.example.dto.LocationResponse;
import org.example.dto.StreetResponse;
import org.example.model.City;
import org.example.model.Country;
import org.example.model.Street;

public class Mapper {
    public static LocationResponse toLocationResponse(Street street){
        return new LocationResponse(
                street.getId(),
                street.getCity().getCountry().getName(),
                street.getCity().getName(),
                street.getName()
                );
    }

    public static CountryResponse toCountryResponse(Country country){
        return new CountryResponse(
                country.getId(),
                country.getName()
        );
    }

    public static CityResponse toCityResponse(City city){
        return new CityResponse(
                city.getId(),
                city.getName()
        );
    }

    public static StreetResponse toStreetResponse(Street street){
        return new StreetResponse(
                street.getId(),
                street.getName()
        );
    }
}
