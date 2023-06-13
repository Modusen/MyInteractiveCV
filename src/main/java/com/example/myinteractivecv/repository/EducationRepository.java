package com.example.myinteractivecv.repository;

import com.example.myinteractivecv.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    List<Education> findAllByUserId(Integer id);
}
