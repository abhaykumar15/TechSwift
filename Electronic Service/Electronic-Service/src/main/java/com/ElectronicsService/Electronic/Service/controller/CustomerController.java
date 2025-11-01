package com.ElectronicsService.Electronic.Service.controller;

import com.ElectronicsService.Electronic.Service.model.*;
import com.ElectronicsService.Electronic.Service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("services", serviceCategoryService.getAllServices());
        return "customer-dashboard";
    }

    @GetMapping("/book/{id}")
    public String bookService(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceCategoryService.getServiceById(id));
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }

    @PostMapping("/book")
    public String submitBooking(@ModelAttribute Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/customer/dashboard";
    }

    @GetMapping("/bookings")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "customer-bookings";
    }
}
