package com.rozplochowski.messaging.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Producer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final AtomicInteger counter = new AtomicInteger(0);

    @Scheduled(fixedRate = 1000)
    void sendMessage() {
        kafkaTemplate.send("message.test", "Message " + counter.incrementAndGet());
    }

}
