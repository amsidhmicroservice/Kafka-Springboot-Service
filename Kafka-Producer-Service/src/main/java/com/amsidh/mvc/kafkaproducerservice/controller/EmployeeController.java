package com.amsidh.mvc.kafkaproducerservice.controller;


import com.amsidh.mvc.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
@Slf4j
public class EmployeeController {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @GetMapping(value = "/send-message")
    public String sendEmployeeToKafkaBroker(@RequestBody Employee employee) {
        log.info("Message published: {}", employee);
        kafkaTemplate.send(topicName, employee);
        return String.format("Message sent on kafka topic %s successfully", topicName);
    }
}
