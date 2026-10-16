package com.rozplochowski.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class NumbersConfiguration {

    @Bean
    @Primary
    Integer meaningOfLife() {
        return 42;
    }

    @Bean
    Double luckyNumber(Integer meaningOfLife) {
        return meaningOfLife / 2.0;
    }

    @Bean
    Short shortNumber() {
        return 123;
    }
}
