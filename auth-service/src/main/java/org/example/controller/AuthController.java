package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AuthRequest;
import org.example.dto.RegisterUserAdvanceRequest;
import org.example.dto.RegisterUserRequest;
import org.example.model.Role;
import org.example.service.AuthService;
import org.example.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterUserRequest request){
        return service.saveUser(request);
    }

    @PostMapping("/register/advanced")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> advanceRegistration( @RequestBody RegisterUserAdvanceRequest request){
       // if(JwtService.hasAnyRole(authorizationHeader, Role.ADMIN))
            return ResponseEntity.ok(service.saveUser(request));
       // return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied!");
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest userCredential){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getUsername(), userCredential.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(authentication.isAuthenticated()){
            return service.generateToken(authentication);
        }
        else
            throw new RuntimeException("invalid credentials");
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        service.validateToken(token);
        return "Token is valid";
    }

}
