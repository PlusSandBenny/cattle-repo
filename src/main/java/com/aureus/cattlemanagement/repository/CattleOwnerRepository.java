package com.aureus.cattlemanagement.repository;

import com.aureus.cattlemanagement.entity.CattleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CattleOwnerRepository extends JpaRepository<CattleOwner, UUID> {
    Optional<CattleOwner> findByEmail(String email);
    Optional<CattleOwner> findByUserId(UUID userId);
    boolean existsByEmail(String email);
}
