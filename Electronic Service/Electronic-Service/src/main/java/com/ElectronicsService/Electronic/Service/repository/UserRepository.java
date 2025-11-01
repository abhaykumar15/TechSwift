package com.ElectronicsService.Electronic.Service.repository;

import com.ElectronicsService.Electronic.Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
