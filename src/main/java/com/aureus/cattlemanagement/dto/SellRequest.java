package com.aureus.cattlemanagement.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SellRequest {
    private UUID cattleId;
    private String instructions;
}
