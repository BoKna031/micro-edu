package org.example.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.enums.RoomType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomResponse{

    private Long id;
    @JsonProperty("hotel-id")
    private long hotelId;
    private int number;
    private int capacity;
    @JsonProperty("type")
    private RoomType roomType;
    @JsonProperty("is-available")
    private boolean isAvailable;

}
