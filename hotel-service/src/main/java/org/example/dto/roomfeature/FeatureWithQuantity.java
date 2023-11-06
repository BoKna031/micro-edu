package org.example.dto.roomfeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureWithQuantity {
    private Long id;
    private int quantity;
}
