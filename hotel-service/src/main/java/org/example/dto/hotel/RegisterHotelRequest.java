package org.example.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RegisterHotelRequest {

    private String name;
    private UUID locationId;
    private int category;
}
