package org.example.dto.roomfeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureWithQuantity {
    private Long id;
    private int quantity;
}
