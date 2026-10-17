package com.rozplochowski.beans.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class ScopedBeanConfig {

    private final Random random = new Random();

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Long randomNumber() {
        return random.nextLong(0, 1000);
    }
}
