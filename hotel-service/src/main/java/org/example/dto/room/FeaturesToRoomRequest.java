package org.example.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeaturesToRoomRequest {
    Long roomId;
    Set<Long> featuresIds;
}
