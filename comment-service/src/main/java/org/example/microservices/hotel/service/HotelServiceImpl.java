package org.example.microservices.hotel.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.HotelRoomDto;
import org.example.microservices.hotel.dto.HotelDto;
import org.example.model.Hotel;
import org.example.model.HotelRoom;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final String PROTOCOL = "http";
    private final String SERVICE_NAME = "hotel-service";

    private final String BASE_URL = PROTOCOL + "://" + SERVICE_NAME;
    private final RestTemplate restTemplate;
    @Override
    public HotelRoom getRoomInfoFromHotelIdAndRoomId(String hotelId, String roomId) throws RestClientException {
        HotelDto response = restTemplate.getForEntity(BASE_URL + "/rest/hotels/" + hotelId,  HotelDto.class).getBody();
        if(response == null)
            return null;
        return new HotelRoom(roomId,  new Hotel(hotelId, response.getName(), response.getAddress()));
    }

    @Override
    public HotelRoom getRoomInfoFromHotelIdAndRoomId(HotelRoomDto room) {
        return getRoomInfoFromHotelIdAndRoomId(room.getHotelId(), room.getRoomId());
    }
}
