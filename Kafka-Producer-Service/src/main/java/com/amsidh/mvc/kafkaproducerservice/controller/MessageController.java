package com.amsidh.mvc.kafkaproducerservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
@Slf4j
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name:javatopic}")
    private String topicName;

    @GetMapping(value = "/send-message")
    public String sendMessageToKafkaBroker(@RequestParam("message") String message) {
        log.info("Message published: {}", message);
        kafkaTemplate.send(topicName, message);
        return String.format("Message sent on kafka topic %s successfully", topicName);
    }
}
