package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.model.Education;
import com.example.myinteractivecv.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@AllArgsConstructor
public class EducationController {
    EducationService educationService;

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationByItsId(@PathVariable Integer id) {
        return ResponseEntity.ok(educationService.getEducation(id));
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Education>> getEducationListByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(educationService.getEducationListByUserId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Education> addEducation(@RequestBody Education education) {
        return ResponseEntity.ok(educationService.addEducation(education));
    }

    @PatchMapping("/edit")
    public ResponseEntity<Education> editEducation(@RequestBody Education education) {
        return ResponseEntity.ok(educationService.editEducation(education));
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Integer id) {
        educationService.deleteEducation(id);
    }
}
