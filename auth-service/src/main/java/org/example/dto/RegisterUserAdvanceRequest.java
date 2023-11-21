package org.example.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserAdvanceRequest {
    @JsonUnwrapped
    private RegisterUserRequest request;
    private Role role;
}
