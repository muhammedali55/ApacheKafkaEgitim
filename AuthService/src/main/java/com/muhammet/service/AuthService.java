package com.muhammet.service;

import com.muhammet.entity.Auth;
import com.muhammet.kafka.producer.AuthKafkaProducer;
import com.muhammet.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final AuthKafkaProducer kafkaProducer;
    public Auth save(String userName,String password, String email){
        Auth auth = repository.save(Auth.builder()
                .email(email)
                .userName(userName)
                .password(password)
                .build());
        kafkaProducer.sendAuthCreate(auth);
        return auth;
    }
}
