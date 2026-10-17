package com.rozplochowski.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Configuration
class NumbersConfiguration {

    @Bean
    @Primary
    Integer meaningOfLife() {
        return 42;
    }

    @Bean
    @DependsOn("meaningOfLife")
    Double luckyNumber(Integer meaningOfLife) {
        return meaningOfLife / 2.0;
    }

    @Bean
    Short shortNumber() {
        return 123;
    }

    @Bean
    Integer age() { return 33; }
}
