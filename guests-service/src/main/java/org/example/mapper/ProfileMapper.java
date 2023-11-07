package org.example.mapper;

import org.example.dto.ProfileRequest;
import org.example.dto.ProfileResponse;
import org.example.model.Profile;

public class ProfileMapper {

    public static Profile toProfile(ProfileRequest request){
        return new Profile(request.getEmail(), request.getTelephone());
    }

    public static ProfileResponse toProfileResponse(Profile profile){
        return new ProfileResponse(
                profile.getId(),
                profile.getEmail(),
                profile.getTelephone()
        );
    }
}
