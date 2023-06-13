package com.example.myinteractivecv.service;

import com.example.myinteractivecv.exception.UserNotFoundException;
import com.example.myinteractivecv.model.User;
import com.example.myinteractivecv.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        return findUserById(id);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id=" + id + " not found"));
    }

}
