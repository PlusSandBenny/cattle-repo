package com.aureus.cattlemanagement.repository;

import com.aureus.cattlemanagement.entity.CattleBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CattleBreedRepository extends JpaRepository<CattleBreed, UUID> {
    Optional<CattleBreed> findByName(String name);
}
