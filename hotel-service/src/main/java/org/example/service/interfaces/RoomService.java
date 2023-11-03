package org.example.service.interfaces;

import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;

public interface RoomService {

    RoomResponse create(RoomRequestWithHotelId request);
}
