package org.example.mapper;

import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;
import org.example.dto.room.RoomResponseWithFeatures;
import org.example.model.Room;

import java.util.stream.Collectors;

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

    public static RoomResponseWithFeatures mapToRoomResponseWithFeatures(Room room){
        return new RoomResponseWithFeatures(
                mapToRoomResponse(room),
                room.getFeatures().stream().map(RoomFeatureMapper::toRoomFeatureWithQuantityResponse).collect(Collectors.toList())
        );
    }
}
