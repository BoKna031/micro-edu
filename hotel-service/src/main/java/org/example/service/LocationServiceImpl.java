package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.location.LocationResponse;
import org.example.service.interfaces.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final String PROTOCOL = "http";
    private final String SERVICE_NAME = "location-service";
    private final String LOCATION_ENDPOINT = "/rest/locations";
    private final String BASE_URL = PROTOCOL + "://" + SERVICE_NAME;
    private final RestTemplate restTemplate;

    @Override
    public LocationResponse getAddressFromLocationUUID(UUID locationId) throws RestClientException {
        ResponseEntity<LocationResponse> response = restTemplate.getForEntity(
                BASE_URL + LOCATION_ENDPOINT + "/" + locationId.toString(),
                LocationResponse.class
        );
        return response.getBody();
    }
}
