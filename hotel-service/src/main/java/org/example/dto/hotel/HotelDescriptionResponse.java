package org.example.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class HotelDescriptionResponse {
    private Long id;
    private String name;
    private UUID location;
    private String address;
    private int category;
}
