package com.ElectronicsService.Electronic.Service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/dashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return "redirect:/customer/dashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TECHNICIAN"))) {
            return "redirect:/technician/dashboard";
        }
        return "redirect:/login?error";
    }
}
