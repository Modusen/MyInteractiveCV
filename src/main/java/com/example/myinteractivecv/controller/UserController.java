package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping({"/{id}"})
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping({"/{id}"})
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
