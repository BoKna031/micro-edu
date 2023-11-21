package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.RegisterUserAdvanceRequest;
import org.example.dto.RegisterUserRequest;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UserCredentialRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserCredentialRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String saveUser(RegisterUserRequest request){
        return saveNewUser(setupNewUser(request));
    }

    public String saveUser(RegisterUserAdvanceRequest request){
        return saveNewUser(setupNewUser(request));
    }

    private String saveNewUser(User user){
        repository.save(user);
        return "User added to system!";
    }

    public String generateToken(Authentication authentication){
        return jwtService.generateToken(authentication);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }

    private User setupNewUser(RegisterUserRequest request){
        RegisterUserAdvanceRequest advanceRequest = new RegisterUserAdvanceRequest(request, Role.USER);
        return setupNewUser(advanceRequest);
    }

    private User setupNewUser(RegisterUserAdvanceRequest request){
        return new User(
                request.getRequest().getName(),
                request.getRequest().getEmail(),
                passwordEncoder.encode(request.getRequest().getPassword()),
                request.getRole());
    }
}
