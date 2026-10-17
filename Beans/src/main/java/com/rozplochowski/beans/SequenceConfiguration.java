package com.rozplochowski.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class),
}, excludeFilters = {
        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = OutOfScanningScopeConfiguration.class),
        @Filter(type = FilterType.REGEX, pattern = "com.rozplochowski.beans.properties.*")
})
class SequenceConfiguration {

    @Bean
    Sequence sequence() {
        return new Sequence("30", "A");
    }
}
