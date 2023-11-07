package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileRequest;
import org.example.dto.ProfileResponse;
import org.example.dto.ProfileUpdateRequest;
import org.example.exception.EntityNotFoundException;
import org.example.model.Profile;
import org.example.service.ProfileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("rest/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    @PostMapping
    public ResponseEntity<ProfileResponse> create(@RequestBody ProfileRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<ProfileResponse>> getAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> getById(@PathVariable UUID id){
        ProfileResponse responseBody = profileService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException(Profile.class, "id", id.toString()));

        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ProfileResponse> getByEmail(@PathVariable String email){
        ProfileResponse responseBody = profileService.getByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(Profile.class, "email", email));
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        profileService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Profile successfully deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> update(@PathVariable UUID id, @RequestBody ProfileUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK)
                .body(profileService.update(id, request));
    }
}
