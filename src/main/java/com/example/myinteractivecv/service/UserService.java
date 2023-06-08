package com.example.myinteractivecv.service;

import com.example.myinteractivecv.exception.UserNotFoundException;
import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found. ID: " + id));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
