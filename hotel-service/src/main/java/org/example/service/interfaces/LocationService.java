package org.example.service.interfaces;

import org.example.dto.location.LocationResponse;
import org.springframework.web.client.RestClientException;

import java.util.UUID;

public interface LocationService {
    LocationResponse getAddressFromLocationUUID(UUID locationId) throws RestClientException;
}
