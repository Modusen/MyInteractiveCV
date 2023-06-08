package com.example.myinteractivecv.repository;

import com.example.myinteractivecv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
