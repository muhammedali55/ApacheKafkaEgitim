package com.muhammet.controller;

import com.muhammet.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-profile")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("get-all")
    public ResponseEntity<List<UserProfile>> getAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }
}
