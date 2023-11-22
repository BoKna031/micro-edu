package org.example.mapper;

import org.example.config.CustomUserDetails;
import org.example.model.Role;
import org.example.model.User;

public class Mapper {

    public static CustomUserDetails toCustomUserDetails(User credential){
        return new CustomUserDetails(credential.getName(), credential.getPassword(), Role.valueOf(credential.getRole()));
    }
}
