package com.rozplochowski.beans.config;

import org.springframework.context.annotation.*;

@Configuration
@Profile("test")
public class TestNumbersConfiguration {

    @Bean
    @Primary
    Integer meaningOfLife() {
        return 69;
    }

    @Bean
    Double luckyNumber() {
        return 7.0;
    }

    @Bean
    Short shortNumber() {
        return -1;
    }

    @Bean
    Integer age() {
        return 101;
    }
}
