package org.example.dto.room;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestWithHotelId{
    @JsonUnwrapped
    private RoomRequest roomRequest;
    private long hotelId;

}
