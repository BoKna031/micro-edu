package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.mapper.UserDetailsMapper;
import org.example.model.UserCredential;
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
        Optional<UserCredential> credential =  credentialRepository.findByName(username);
        return credential.map(UserDetailsMapper::toCustomUserDetails).orElseThrow(() -> new RuntimeException("Not valid credentials!"));
    }
}
