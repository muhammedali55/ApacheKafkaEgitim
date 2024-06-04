package com.muhammet.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ApacheKafkaEgitimApplication {

    private final KafkaTemplate<Integer,String> template;

    //private final KafkaTemplate<String,Object> defaultTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ApacheKafkaEgitimApplication.class, args);
    }

    @GetMapping("/topic")
    public void newTopic(){
        template.send("muhammet-topic1",1,"Selam Muhammet HOCAM nasılsın");
    }
    @GetMapping("/topic1")
    public void newTopic1(){
        template.send("topic1",1,"İyi dir sen nasılsın");
    }

    @KafkaListener(id = "myId1", topics = "topic1")
    public void listen(String in) {
        System.out.println(in);
    }

    @KafkaListener(id = "myId", topics = "muhammet-topic1")
    public void listen2(String in) {
        System.out.println(in);
    }

}
