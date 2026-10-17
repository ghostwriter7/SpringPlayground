package com.rozplochowski.appevents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {


    private final Logger logger = LoggerFactory.getLogger(CustomEventListener.class);

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        logger.info("Received custom event: {}", event.message());
    }
}
