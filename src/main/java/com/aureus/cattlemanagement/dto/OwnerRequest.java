package com.aureus.cattlemanagement.dto;

import lombok.Data;

@Data
public class OwnerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String password;
}
