package com.aureus.cattlemanagement.dto;

import com.aureus.cattlemanagement.entity.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CattleResponse {
    private UUID id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String breedName;
    private UUID breedId;
    private UUID ownerId;
    private String ownerName;
    private UUID currentOwnerId;
    private String currentOwnerName;
    private boolean forSale;
    private String saleInstructions;
    private LocalDateTime createdAt;
}
