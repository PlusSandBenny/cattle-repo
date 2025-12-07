package com.aureus.cattlemanagement.repository;

import com.aureus.cattlemanagement.entity.Cattle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CattleRepository extends JpaRepository<Cattle, UUID> {
    List<Cattle> findByOwnerId(UUID ownerId);
    List<Cattle> findByCurrentOwnerId(UUID currentOwnerId);
    List<Cattle> findByForSaleTrue();
}
