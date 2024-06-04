package com.muhammet.kafka.producer;

import com.muhammet.entity.Auth;
import com.muhammet.kafka.model.ConsumerAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthKafkaProducer {
    private final KafkaTemplate<String, ConsumerAuth> kafkaTemplate;

    public void sendAuthCreate(Auth auth){
        kafkaTemplate.send("auth-create","create", ConsumerAuth.builder()
                        .authId(auth.getId())
                        .email(auth.getEmail())
                        .userName(auth.getUserName())
                .build());
    }
}
