package org.example.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.dto.roomfeature.RoomFeatureWithQuantityResponse;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseWithFeatures extends RoomResponse{
    List<RoomFeatureWithQuantityResponse> features;

    public RoomResponseWithFeatures(RoomResponse roomResponse, List<RoomFeatureWithQuantityResponse>  features){
        super(roomResponse.getId(), roomResponse.getHotelId(), roomResponse.getNumber(), roomResponse.getCapacity(), roomResponse.getRoomType(), roomResponse.isAvailable());
        this.features = features;
    }
}
