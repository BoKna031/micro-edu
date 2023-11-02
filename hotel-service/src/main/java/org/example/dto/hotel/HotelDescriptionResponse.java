package org.example.dto.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelDescriptionResponse {
    private Long id;
    private String name;
    private String address;
    private int category;
}
