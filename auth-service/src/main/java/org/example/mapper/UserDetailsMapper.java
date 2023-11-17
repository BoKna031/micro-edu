package org.example.mapper;

import org.example.config.CustomUserDetails;
import org.example.dto.AuthRequest;
import org.example.model.UserCredential;

public class UserDetailsMapper {

    public static CustomUserDetails toCustomUserDetails(UserCredential credential){
        return new CustomUserDetails(credential.getName(), credential.getPassword());
    }
}
