package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class TestAuthController {
    @GetMapping("/registrations")
    public String register(@ModelAttribute("user") User user) {
//        Role role = user.getRole() == null ? CANDIDATE : user.getRole();
//        if (authService.register(user, role)) {
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
        return "registration";
    }
}
