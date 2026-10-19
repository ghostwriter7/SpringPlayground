package com.rozplochowski.messaging.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Consumer {

    @KafkaListener(topics = "message.test", groupId = "TestConsumerGroupId")
    void receiveMessage(String message) {
        log.info("Received message: {}", message);
    }
}
