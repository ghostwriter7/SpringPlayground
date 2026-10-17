package com.rozplochowski.appevents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class AppContextEventListener {
    private final Logger logger = LoggerFactory.getLogger(AppContextEventListener.class);

    @EventListener(ContextRefreshedEvent.class)
    public void handleContextRefreshedEvent() {
        logger.info("Context refreshed");
    }

    @EventListener(ContextClosedEvent.class)
    public void handleContextClosedEvent() {
        logger.info("Context closed");
    }

    @EventListener(ContextStoppedEvent.class)
    public void handleContextStoppedEvent() {
        logger.info("Context stopped");
    }

    @EventListener(ContextRestartedEvent.class)
    public void handleContextRestartedEvent() {
        logger.info("Context restarted");
    }

}
