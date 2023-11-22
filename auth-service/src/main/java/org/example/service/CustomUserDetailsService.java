package org.example.service;

import org.example.mapper.Mapper;
import org.example.model.User;
import org.example.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository credentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> credential =  credentialRepository.findByName(username);
        return credential.map(Mapper::toCustomUserDetails).orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}
