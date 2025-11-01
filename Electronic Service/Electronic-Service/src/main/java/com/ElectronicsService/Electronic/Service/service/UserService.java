package com.ElectronicsService.Electronic.Service.service;

import com.ElectronicsService.Electronic.Service.model.User;
import com.ElectronicsService.Electronic.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole() == null) user.setRole("ROLE_CUSTOMER");
        repo.save(user);
    }

    public boolean emailExists(String email) {
        return repo.findByEmail(email).isPresent();
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
