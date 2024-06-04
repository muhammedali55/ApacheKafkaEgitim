package com.muhammet.kafka.consumer;

import com.muhammet.entity.UserProfile;
import com.muhammet.kafka.model.ConsumerAuth;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthConsumer {
    private final UserProfileService userProfileService;

    @KafkaListener(id = "createAuth",topics = "auth-create")
    public void createAuthConsumer(ConsumerAuth consumerAuth){
        userProfileService.save(UserProfile.builder()
                        .authId(consumerAuth.getAuthId())
                        .email(consumerAuth.getEmail())
                        .userName(consumerAuth.getUserName())
                .build());
        log.info("Topik Geldi......: "+ consumerAuth);
    }
}
