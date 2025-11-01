package com.ElectronicsService.Electronic.Service.service;

import com.ElectronicsService.Electronic.Service.model.User;
import com.ElectronicsService.Electronic.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Checks if a user with the given email already exists.
     * @param email The user's email to check.
     * @return true if email already exists, otherwise false.
     */
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    /**
     * Saves a new user after encoding the password.
     * Assigns a default role (ROLE_CUSTOMER) if not provided.
     * @param user The user to be saved.
     */
    public void saveUser(User user) {
        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Ensure role is not null
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_CUSTOMER");
        }

        userRepository.save(user);
    }
}
