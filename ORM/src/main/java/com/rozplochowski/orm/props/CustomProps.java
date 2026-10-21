package com.rozplochowski.orm.props;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "custom")
public class CustomProps {

    private final String propertyValue;
    private final String propertyValue2;
    private final String propertyValue3;
    private final int customInt;
    private final List<String> list;

    @PostConstruct
    void init() {log.info("Custom properties are: propertyValue={}, propertyValue2={}, propertyValue3={}, list={}", propertyValue, propertyValue2, propertyValue3, list);
    }
}

