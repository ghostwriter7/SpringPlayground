package com.rozplochowski.appevents;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void logUserAction(String message) {
        LogEvent logEvent = new LogEvent(this, message);
        eventPublisher.publishEvent(logEvent);
    }

    public void logUserActionWithCustomEvent(String message) {
        CustomEvent customEvent = new CustomEvent(message);
        eventPublisher.publishEvent(customEvent);
    }
}
