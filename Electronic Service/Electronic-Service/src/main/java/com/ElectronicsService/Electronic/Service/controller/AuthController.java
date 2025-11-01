package com.ElectronicsService.Electronic.Service.controller;

import com.ElectronicsService.Electronic.Service.model.User;
import com.ElectronicsService.Electronic.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    /*@Autowired
    private PasswordEncoder passwordEncoder;
*/
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, Model model) {
        // Check if email already exists
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }

        // Encode password before saving
        //user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role for new users → CUSTOMER
        user.setRole("ROLE_CUSTOMER");

        // Save user in database
        userService.saveUser(user);

        // Redirect with success message to login
        model.addAttribute("success", "Registration successful! Please log in.");
        return "redirect:/login?registered";
    }
}
