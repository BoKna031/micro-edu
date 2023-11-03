package org.example.mapper;

import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;
import org.example.model.Room;

public class RoomMapper {
    public static Room maptoRoom(RoomRequestWithHotelId request){
        return new Room(
                request.getRoomRequest().getNumber(),
                request.getRoomRequest().getCapacity(),
                true,
                request.getRoomRequest().getRoomType(),
                null,
                null);
    }

    public static RoomResponse mapToRoomResponse(Room room){
        return new RoomResponse(
                room.getId(),
                room.getHotel().getId(),
                room.getNumber(),
                room.getCapacity(),
                room.getRoomType(),
                room.isAvailable()
        );
    }
}
