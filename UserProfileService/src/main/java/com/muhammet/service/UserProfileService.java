package com.muhammet.service;

import com.muhammet.entity.UserProfile;
import com.muhammet.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public UserProfile save(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> findAll(){
        return userProfileRepository.findAll();
    }

}
