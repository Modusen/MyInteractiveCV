package com.example.myinteractivecv.repository;

import com.example.myinteractivecv.model.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocialRepository extends JpaRepository<Social, Integer> {

    public List<Social> findAllByUserId_Id(Integer userId);
}
