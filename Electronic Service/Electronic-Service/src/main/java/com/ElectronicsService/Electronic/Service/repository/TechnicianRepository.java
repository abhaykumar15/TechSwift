package com.ElectronicsService.Electronic.Service.repository;

import com.ElectronicsService.Electronic.Service.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
