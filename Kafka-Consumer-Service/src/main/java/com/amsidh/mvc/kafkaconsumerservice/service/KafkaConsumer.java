package com.amsidh.mvc.kafkaconsumerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name:javatopic}", groupId = "${spring.kafka.consumer.groupId:myGroup}")
    public void consumeMessage(String message){
        log.info("Message consumed: {}", message);
    }
}
