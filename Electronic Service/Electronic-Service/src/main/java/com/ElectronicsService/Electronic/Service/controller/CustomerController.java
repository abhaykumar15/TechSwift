package com.ElectronicsService.Electronic.Service.controller;
import org.springframework.security.core.context.SecurityContextHolder;

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
        org.springframework.security.core.userdetails.User currentUser =
                (org.springframework.security.core.userdetails.User)
                        org.springframework.security.core.context.SecurityContextHolder
                                .getContext().getAuthentication().getPrincipal();

        User customer = bookingService.getUserByEmail(currentUser.getUsername());

        model.addAttribute("services", serviceCategoryService.getAllServices());
        model.addAttribute("bookings", bookingService.getAllBookingsByCustomer(customer));

        return "customer-dashboard";
    }


    @GetMapping("/book/{id}")
    public String bookService(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceCategoryService.getServiceById(id));
        model.addAttribute("booking", new Booking());
        return "bookin-form";
    }

    @PostMapping("/book")
    public String submitBooking(@ModelAttribute Booking booking,
                                @RequestParam("serviceCategoryId") Long serviceCategoryId) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = (principal instanceof org.springframework.security.core.userdetails.User)
                ? ((org.springframework.security.core.userdetails.User) principal).getUsername()
                : principal.toString();

        User customer = bookingService.getUserByEmail(email);
        ServiceCategory service = serviceCategoryService.getServiceById(serviceCategoryId);

        booking.setCustomer(customer);
        booking.setServiceCategory(service);
        bookingService.createBooking(booking);

        return "redirect:/customer/dashboard";
    }



    @GetMapping("/bookings")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "customer-bookings";
    }

}
