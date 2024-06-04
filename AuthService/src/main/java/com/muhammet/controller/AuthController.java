package com.muhammet.controller;

import com.muhammet.entity.Auth;
import com.muhammet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/save")
    public ResponseEntity<Auth> save(String userName, String password, String email){
        Auth auth = authService.save(userName, password, email);
        return ResponseEntity.ok(auth);
    }
}
