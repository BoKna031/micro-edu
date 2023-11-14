package org.example.microservices.hotel.service;

import org.example.dto.HotelRoomDto;
import org.example.model.HotelRoom;

public interface HotelService {
    HotelRoom getRoomInfoFromHotelIdAndRoomId(String hotelId, String roomId);
    HotelRoom getRoomInfoFromHotelIdAndRoomId(HotelRoomDto hotelRoomDto);
}
