package org.example.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.enums.RoomType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    @JsonProperty("hotel-id")
    private long hotelId;
    private int number;
    private int capacity;
    @JsonProperty("type")
    private RoomType roomType;
}
