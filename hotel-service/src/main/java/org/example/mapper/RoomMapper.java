package org.example.mapper;

import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomResponse;
import org.example.model.Room;

public class RoomMapper {
    public static Room maptoRoom(RoomRequest request){
        return new Room(
                request.getNumber(),
                request.getCapacity(),
                true,
                request.getRoomType(),
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
