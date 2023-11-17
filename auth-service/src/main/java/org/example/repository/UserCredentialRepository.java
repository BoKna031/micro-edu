package org.example.repository;

import org.example.model.UserCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCredentialRepository extends MongoRepository<UserCredential, String> {
    Optional<UserCredential> findByName(String name);
}
