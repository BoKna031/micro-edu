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
    private final String HOST = "localhost";
    private final String PORT = "8081";
    private final String SERVICE = "rest/locations";
    private final String BASE_URL = PROTOCOL + "://" + HOST + ":" + PORT +  "/" + SERVICE;
    private final RestTemplate restTemplate;

    @Override
    public LocationResponse getAddressFromLocationUUID(UUID locationId) throws RestClientException {
        ResponseEntity<LocationResponse> response = restTemplate.getForEntity(
                BASE_URL + "/" + locationId.toString(),
                LocationResponse.class
        );
        return response.getBody();
    }
}
