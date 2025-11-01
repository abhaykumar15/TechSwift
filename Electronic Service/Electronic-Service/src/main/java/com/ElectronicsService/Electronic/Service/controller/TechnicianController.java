package com.ElectronicsService.Electronic.Service.controller;

import com.ElectronicsService.Electronic.Service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("assignedBookings", bookingService.getAssignedBookings());
        return "technician-dashboard";
    }

    @PostMapping("/update-status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        bookingService.updateStatus(id, status);
        return "redirect:/technician/dashboard";
    }
}
