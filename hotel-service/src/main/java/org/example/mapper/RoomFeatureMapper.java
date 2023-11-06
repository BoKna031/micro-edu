package org.example.mapper;

import org.example.dto.roomfeature.CreateFeatureRequest;
import org.example.dto.roomfeature.RoomFeatureResponse;
import org.example.dto.roomfeature.RoomFeatureWithQuantityResponse;
import org.example.model.IncludedRoomFeature;
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

    public static RoomFeatureWithQuantityResponse toRoomFeatureWithQuantityResponse(IncludedRoomFeature includedRoomFeature){
        return new RoomFeatureWithQuantityResponse(
                toRoomFeatureResponse(includedRoomFeature.getFeature()),
                includedRoomFeature.getQuantity()
        );
    }
}
