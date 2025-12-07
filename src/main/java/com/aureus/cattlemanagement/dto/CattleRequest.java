package com.aureus.cattlemanagement.dto;

import com.aureus.cattlemanagement.entity.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CattleRequest {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private UUID breedId;
}
