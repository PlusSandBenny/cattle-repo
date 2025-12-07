package com.aureus.cattlemanagement.repository;

import com.aureus.cattlemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByActivationToken(String activationToken);
    boolean existsByEmail(String email);
}
