package com.rozplochowski.appevents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class LogListener implements ApplicationListener<LogEvent> {
    private final Logger logger = LoggerFactory.getLogger(LogListener.class);

    @Override
    public void onApplicationEvent(LogEvent event) {
        logger.info("Received event: {} at {}", event.getMessage(), Instant.ofEpochMilli(event.getTimestamp()));
    }
}
