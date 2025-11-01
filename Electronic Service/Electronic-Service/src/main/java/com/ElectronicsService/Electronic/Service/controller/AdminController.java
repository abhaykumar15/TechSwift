package com.ElectronicsService.Electronic.Service.controller;

import com.ElectronicsService.Electronic.Service.model.*;
import com.ElectronicsService.Electronic.Service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TechnicianService technicianService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("technicians", technicianService.getAllTechnicians());
        return "admin-dashboard";
    }

    @GetMapping("/assign/{bookingId}/{technicianId}")
    public String assignTechnician(@PathVariable Long bookingId, @PathVariable Long technicianId) {
        bookingService.assignTechnician(bookingId, technicianId);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/services")
    public String manageServices(Model model) {
        model.addAttribute("services", serviceCategoryService.getAllServices());
        return "admin-services";
    }
}
