package org.example.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterHotelRequest {
    private String name;
    private String address;
    private int category;
}
