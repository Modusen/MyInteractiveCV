package com.example.myinteractivecv.repository;

import com.example.myinteractivecv.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
