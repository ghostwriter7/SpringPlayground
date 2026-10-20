package com.rozplochowski.messaging.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/{key}")
    void sendMessage(
            @PathVariable String key,
            @RequestBody String message) {
        kafkaTemplate.send("message.test", key, message);
    }
}
