package org.example.mapper;

import org.example.config.CustomUserDetails;
import org.example.model.User;

public class Mapper {

    public static CustomUserDetails toCustomUserDetails(User credential){
        return new CustomUserDetails(credential.getName(), credential.getPassword(), credential.getRole());
    }
}
