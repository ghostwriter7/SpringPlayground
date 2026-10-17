package com.rozplochowski.beans.config;

import com.rozplochowski.beans.OutOfScanningScopeConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Fallback;
import org.springframework.context.annotation.Import;

@Configuration
@Import(OutOfScanningScopeConfiguration.class)
class StringConfiguration {

    @Bean
    String name(@Qualifier("age") Integer age) {
        return "Hubert " + age;
    }

    @Bean
    @Fallback
    String nickname() {
        return "ghostwriter";
    }

    @Bean
    String address(@Qualifier("city") String city) {
        return "Poland, " + city;
    }

}
