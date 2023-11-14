package org.example.microservices.guest.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.guest.dto.GuestDto;
import org.example.model.Guest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService{

    private final String PROTOCOL = "http";
    private final String SERVICE_NAME = "guest-service";
    private final String BASE_URL = PROTOCOL + "://" + SERVICE_NAME;
    private final RestTemplate restTemplate;


    @Override
    public Guest getGuestById(String guestId) {
        GuestDto response = restTemplate.getForEntity(BASE_URL + "/rest/profiles/" + guestId, GuestDto.class).getBody();
        if(response == null)
            return null;
        return new Guest(response.getId(), response.getEmail());
    }
}
