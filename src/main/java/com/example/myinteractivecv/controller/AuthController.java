package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.dto.LoginReqDto;
import com.example.myinteractivecv.model.Role;
import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.myinteractivecv.model.Role.CANDIDATE;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginReqDto req) {
//        if (authService.login(req.getEmail(), req.getPassword())) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(name = "email") String email,
                                   @RequestParam(name = "password") String password) {
        if (authService.login(email, password)) {
            System.out.println("Прошла аутентификация");
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> register(@ModelAttribute("user") User user) {
        Role role = user.getRole() == null ? CANDIDATE : user.getRole();
        if (authService.register(user, role)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
