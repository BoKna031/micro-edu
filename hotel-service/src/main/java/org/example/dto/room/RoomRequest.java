package org.example.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.roomfeature.FeatureWithQuantity;
import org.example.model.enums.RoomType;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private int number;
    private int capacity;
    @JsonProperty("type")
    private RoomType roomType;
    @JsonProperty("room-features")
    private Set<FeatureWithQuantity> features;
}
