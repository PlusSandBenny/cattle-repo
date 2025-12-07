package com.aureus.cattlemanagement.service;

import com.aureus.cattlemanagement.entity.User;
import com.aureus.cattlemanagement.exception.ActivationExpiredException;
import com.aureus.cattlemanagement.exception.ResourceNotFoundException;
import com.aureus.cattlemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public User createUser(String email, String password, String role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setActivated(false);
        user.setActivationToken(UUID.randomUUID().toString());
        user.setActivationTokenExpiry(LocalDateTime.now().plusDays(3));

        User savedUser = userRepository.save(user);

        // Send activation email
        emailService.sendActivationEmail(email, savedUser.getActivationToken());

        return savedUser;
    }

    public void activateUser(String activationToken) {
        User user = userRepository.findByActivationToken(activationToken)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid activation token"));

        if (user.getActivationTokenExpiry().isBefore(LocalDateTime.now())) {
            throw new ActivationExpiredException("Activation link has expired");
        }

        user.setActivated(true);
        user.setActivationToken(null);
        user.setActivationTokenExpiry(null);
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }
}
