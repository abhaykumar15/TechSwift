package com.ElectronicsService.Electronic.Service.service;

import com.ElectronicsService.Electronic.Service.model.Technician;
import com.ElectronicsService.Electronic.Service.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repo;

    public List<Technician> getAllTechnicians() {
        return repo.findAll();
    }

    public Technician getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Technician save(Technician t) {
        return repo.save(t);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
