package com.aureus.cattlemanagement.service;

import com.aureus.cattlemanagement.dto.OwnerRequest;
import com.aureus.cattlemanagement.dto.OwnerResponse;
import com.aureus.cattlemanagement.entity.CattleOwner;
import com.aureus.cattlemanagement.entity.User;
import com.aureus.cattlemanagement.exception.ResourceNotFoundException;
import com.aureus.cattlemanagement.repository.CattleOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private CattleOwnerRepository ownerRepository;
    private UserService userService;

    public OwnerResponse registerOwner(OwnerRequest request) {
        // Create user first
        User user = userService.createUser(request.getEmail(), request.getPassword(), "OWNER");

        // Create cattle owner
        CattleOwner owner = new CattleOwner();
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setAddress(request.getAddress());
        owner.setUser(user);

        CattleOwner savedOwner = ownerRepository.save(owner);
        return mapToResponse(savedOwner);
    }

    public List<OwnerResponse> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public OwnerResponse getOwnerById(UUID id) {
        CattleOwner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
        return mapToResponse(owner);
    }

    public CattleOwner getOwnerByUserId(UUID userId) {
        return ownerRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for user id: " + userId));
    }

    public CattleOwner getOwnerByEmail(String email) {
        return ownerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with email: " + email));
    }

    private OwnerResponse mapToResponse(CattleOwner owner) {
        OwnerResponse response = new OwnerResponse();
        response.setId(owner.getId());
        response.setFirstName(owner.getFirstName());
        response.setLastName(owner.getLastName());
        response.setEmail(owner.getEmail());
        response.setPhone(owner.getPhone());
        response.setAddress(owner.getAddress());
        response.setActivated(owner.getUser().isActivated());
        response.setCreatedAt(owner.getCreatedAt());
        return response;
    }
}
