package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LocationResponse {
    private UUID id;
    private String country;
    private String city;
    private String street;
}
