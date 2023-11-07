package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileRequest;
import org.example.dto.ProfileResponse;
import org.example.dto.ProfileUpdateRequest;
import org.example.exception.EntityNotFoundException;
import org.example.exception.UniqueConstraintException;
import org.example.mapper.ProfileMapper;
import org.example.model.Profile;
import org.example.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;
    @Override
    public ProfileResponse create(ProfileRequest request) {
        if(getByEmail(request.getEmail()).isPresent())
            throw new UniqueConstraintException("Email", request.getEmail());
        Profile savedProfile = profileRepository.save(ProfileMapper.toProfile(request));
        return ProfileMapper.toProfileResponse(savedProfile);
    }

    @Override
    public Optional<ProfileResponse> getByEmail(String email) {
        Optional<Profile> profile = profileRepository.findByEmail(email);
        return profile.map(ProfileMapper::toProfileResponse);
    }

    @Override
    public Optional<ProfileResponse> getById(UUID id) {
        return Optional.of(ProfileMapper.toProfileResponse(getByIdOrThrowEntityNotFound(id)));
    }

    @Override
    public Page<ProfileResponse> getAll(Pageable pageable) {
        return profileRepository.findAll(pageable)
                .map(ProfileMapper::toProfileResponse);
    }

    @Override
    public ProfileResponse update(UUID id, ProfileUpdateRequest request) {
        Profile profile = getByIdOrThrowEntityNotFound(id);

        if(request.getEmail() != null && !request.getEmail().isBlank()){
            if(profileRepository.findByEmail(request.getEmail()).isPresent())
                throw new UniqueConstraintException("email", request.getEmail());
            profile.setEmail(request.getEmail());
        }

        if(request.getTelephone() != null && !request.getTelephone().isBlank())
            profile.setTelephone(request.getTelephone());
        return ProfileMapper.toProfileResponse(profileRepository.save(profile));
    }

    @Override
    public void delete(UUID profileId) {
        getByIdOrThrowEntityNotFound(profileId);
        profileRepository.deleteById(profileId);
    }

    private Profile getByIdOrThrowEntityNotFound(UUID id){
        return profileRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(Profile.class, "id", id.toString()));
    }
}
