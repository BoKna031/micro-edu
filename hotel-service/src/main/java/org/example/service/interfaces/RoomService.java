package org.example.service.interfaces;

import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;
import org.example.dto.room.RoomResponseWithFeatures;

public interface RoomService {

    RoomResponse create(RoomRequestWithHotelId request);

    RoomResponse getRoomResponseById(long id);

    RoomResponseWithFeatures getRoomResponseWithFeaturesById(long id);
}
