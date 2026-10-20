package com.rozplochowski.messaging.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
@PropertySource("classpath:configuration.properties")
class AppConfig {


}
