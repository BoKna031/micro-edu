package org.example.dto.roomfeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomFeatureResponse {
    private Long id;
    private String name;
    private String description;
}
