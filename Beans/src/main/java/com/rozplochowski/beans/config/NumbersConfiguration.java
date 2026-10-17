package com.rozplochowski.beans.config;

import org.springframework.context.annotation.*;

@Configuration
@Profile("prod")
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
