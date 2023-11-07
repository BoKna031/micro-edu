package org.example.service;

import org.example.dto.ProfileRequest;
import org.example.dto.ProfileResponse;
import org.example.dto.ProfileUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface ProfileService {

    ProfileResponse create(ProfileRequest request);
    Optional<ProfileResponse> getByEmail(String email);

    Optional<ProfileResponse> getById(UUID id);
    Page<ProfileResponse> getAll(Pageable pageable);

    ProfileResponse update(UUID id, ProfileUpdateRequest request);

    void delete(UUID profileId);

}
