package com.ElectronicsService.Electronic.Service.repository;

import com.ElectronicsService.Electronic.Service.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
