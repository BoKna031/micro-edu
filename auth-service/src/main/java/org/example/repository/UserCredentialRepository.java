package org.example.repository;

import org.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCredentialRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String username);
}
