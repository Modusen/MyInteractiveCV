package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.model.Role;
import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.myinteractivecv.model.Role.CANDIDATE;

@Controller
@RequestMapping()
@AllArgsConstructor
public class MVCController {
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/greetings")
    public String greetingPage() {
        return "greetings";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") User user) {
        Role role = user.getRole() == null ? CANDIDATE : user.getRole();
        if (authService.register(user, role)) {
            return "redirect:/login";
        } else {
            return "redirect:/registration";
        }
    }
}
