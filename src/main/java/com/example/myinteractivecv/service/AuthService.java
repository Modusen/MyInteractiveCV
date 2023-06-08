package com.example.myinteractivecv.service;

import com.example.myinteractivecv.model.Role;
import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public boolean login(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> encoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    public boolean register(User user, Role role) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        user.setRole(role);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
