package org.example.dto.roomfeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomFeatureWithQuantityResponse extends RoomFeatureResponse{
    int quantity;

    public RoomFeatureWithQuantityResponse(RoomFeatureResponse roomFeatureResponse, int quantity) {
        super(roomFeatureResponse.getId(), roomFeatureResponse.getName(), roomFeatureResponse.getDescription());
        this.quantity = quantity;
    }
}
