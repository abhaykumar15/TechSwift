package com.ElectronicsService.Electronic.Service.repository;

import com.ElectronicsService.Electronic.Service.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {
}
