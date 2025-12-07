package com.aureus.cattlemanagement.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String refreshToken;
    private String email;
    private String role;

    public AuthResponse(String token, String refreshToken, String email, String role) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.email = email;
        this.role = role;
    }
}
