package org.example.mapper;

import org.example.dto.roomfeature.CreateFeatureRequest;
import org.example.dto.roomfeature.RoomFeatureResponse;
import org.example.model.RoomFeature;

public class RoomFeatureMapper {
    public static RoomFeature toRoomFeature(CreateFeatureRequest request){
        return new RoomFeature(
                request.getName(),
                request.getDescription()
        );
    }

    public static RoomFeatureResponse toRoomFeatureResponse(RoomFeature room){
        return new RoomFeatureResponse(
                room.getId(),
                room.getName(),
                room.getDescription()
        );
    }
}
