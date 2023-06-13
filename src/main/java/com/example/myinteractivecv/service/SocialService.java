package com.example.myinteractivecv.service;

import com.example.myinteractivecv.model.Social;
import com.example.myinteractivecv.repository.SocialRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SocialService {
    SocialRepository socialRepository;

    public Social addSocial(Social social) {
        return socialRepository.save(social);
    }

    public List<Social> getSocialsByUserId(Integer userId) {
        return socialRepository.findAllByUserId_Id(userId);
    }

    public Social getSocialById(Integer id) {
        return findSocialById(id);
    }

    public Social editSocial(Social social) {
        Social foundSocial = findSocialById(social.getId());
        return socialRepository.save(social);
    }

    public void deleteSocial(Integer id) {
        socialRepository.deleteById(id);
    }

    public Social findSocialById(Integer id) {
        return socialRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Social with id=" + id + " not found"));
    }

}
