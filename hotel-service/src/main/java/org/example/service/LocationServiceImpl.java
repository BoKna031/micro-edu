package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.hc.core5.http.Method;
import org.example.dto.location.LocationResponse;
import org.example.event.CommunicationEvent;
import org.example.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final KafkaTemplate<String, CommunicationEvent> kafkaTemplate;

    @Value("${spring.application.name}")
    private String hostServiceName;

    @Override
    public LocationResponse getAddressFromLocationUUID(UUID locationId) throws RestClientException {
        String url = BASE_URL + LOCATION_ENDPOINT + "/" + locationId.toString();
        ResponseEntity<LocationResponse> response = restTemplate.getForEntity(
                url, LocationResponse.class);
        kafkaTemplate.send("communicationTopic", new CommunicationEvent(url, Method.GET.toString(), hostServiceName , SERVICE_NAME, response.getStatusCode().toString()));
        return response.getBody();
    }
}
