package com.rozplochowski.messaging.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Consumer {

    @KafkaListener(topics = "message.test", groupId = "TestConsumerGroupId")
    void receiveMessage(ConsumerRecord<String, String> message) {
        log.info("Received: key={}, value={}, timestamp={}, partition={}, offset={}",
                message.key(), message.value(), Instant.ofEpochMilli(message.timestamp()), message.partition(), message.offset());
    }
}
