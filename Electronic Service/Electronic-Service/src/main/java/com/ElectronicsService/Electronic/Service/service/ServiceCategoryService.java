package com.ElectronicsService.Electronic.Service.service;

import com.ElectronicsService.Electronic.Service.model.ServiceCategory;
import com.ElectronicsService.Electronic.Service.repository.ServiceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoryService {

    @Autowired
    private ServiceCategoryRepository repo;

    public List<ServiceCategory> getAllServices() {
        return repo.findAll();
    }

    public ServiceCategory getServiceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ServiceCategory addService(ServiceCategory service) {
        return repo.save(service);
    }
}
