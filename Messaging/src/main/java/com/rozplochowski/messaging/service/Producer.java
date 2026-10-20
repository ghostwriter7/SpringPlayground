package com.rozplochowski.messaging.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@ConditionalOnBooleanProperty(name = "app.create-producer")
class Producer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final AtomicInteger counter = new AtomicInteger(0);

    @Scheduled(initialDelay = 1_000, fixedDelay = 10_000)
    void sendMessage() {
        CompletableFuture<SendResult<String, String>> result = kafkaTemplate.send("message.test", "Message " + counter.incrementAndGet());

        result.whenComplete((res, ex) -> {
            if (ex != null) {
                log.error("Error sending message", ex);
            } else {
                var metadata = res.getRecordMetadata();
                log.info("Received confirmation for for topic: {}, partition: {}, offset: {}, timestamp: {}",
                        metadata.topic(), metadata.partition(), metadata.offset(), Instant.ofEpochMilli(metadata.timestamp()));
            }
        });
    }


}
