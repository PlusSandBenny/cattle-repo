package com.aureus.cattlemanagement.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransferRequest {
    private UUID cattleId;
    private UUID newOwnerId;
}
