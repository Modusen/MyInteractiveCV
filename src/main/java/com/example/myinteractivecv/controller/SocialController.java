package com.example.myinteractivecv.controller;

import com.example.myinteractivecv.model.Social;
import com.example.myinteractivecv.service.SocialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socials")
@AllArgsConstructor
public class SocialController {
    SocialService socialService;

    @GetMapping({"/{id}"})
    public ResponseEntity<Social> getSocialById(@PathVariable Integer id) {
        return ResponseEntity.ok(socialService.getSocialById(id));
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Social>> getSocialsByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(socialService.getSocialsByUserId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Social> addSocial(Social social) {
        return ResponseEntity.ok(socialService.addSocial(social));
    }

    @PatchMapping("/edit")
    public ResponseEntity<Social> editSocialById(@RequestBody Social social) {
        return ResponseEntity.ok(socialService.editSocial(social));
    }

    @DeleteMapping("/{id}")
    public void deleteSocial(@PathVariable Integer id) {
        socialService.deleteSocial(id);
    }
}
