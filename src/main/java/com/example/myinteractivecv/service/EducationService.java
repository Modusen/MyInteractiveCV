package com.example.myinteractivecv.service;

import com.example.myinteractivecv.model.Education;
import com.example.myinteractivecv.repository.EducationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EducationService {

    EducationRepository educationRepository;

    public void addEducation(Education education) {
        educationRepository.save(education);
    }

    public Education getEducation(Integer id) {
        return findEducationById(id);
    }

    public List<Education> getEducationListByUserId(Integer userId) {
        return educationRepository.findAllByUserId(userId);
    }

    public Education editEducation(Education education) {
        Education foundEducation = findEducationById(education.getId());
        return educationRepository.save(education);
    }

    public void deleteEducation(Integer id) {
        educationRepository.deleteById(id);
    }

    public Education findEducationById(Integer id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Education with id=" + id + " not found"));
    }
}
