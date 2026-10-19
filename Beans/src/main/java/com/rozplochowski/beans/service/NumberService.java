package com.rozplochowski.beans.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Lazy
@Service
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class NumberService {

    private final List<Number> numbers; // 42 & 21.0 as defined in config.NumbersConfig

    // numbers by bean name (e.g. "meaningOfLife" -> 42)
    private final Map<String, Number> numbersByName;
    private final ObjectProvider<Short> shortObjectProvider;

    // meaningOfLife due to @Primary annotation
    private final Number mostImportantNumber;

    @Qualifier("luckyNumber")
    private final Number luckyNumber;

    @PostConstruct
    public void init() {
        log.info("ObjectProvider for Short provided: {}", shortObjectProvider.getIfUnique());

        log.info("Most important number: {}", mostImportantNumber);
        log.info("Lucky number: {}", luckyNumber);
    }

    // There is no Float bean, but it is optional, no errors
    @Autowired(required = false)
    public void setFloatNumber(Float floatNumber) {
        numbersByName.put("floatNumber", floatNumber);
    }

    @Autowired
    public void setByte(Optional<Byte> optionalByte) {
        numbersByName.put("tinyByte", optionalByte.orElse((byte) 1));
    }

    public void printNumbers() {
        log.info(numbers.toString());
    }

    public void printNumbersIndex() {
        log.info(numbersByName.toString());
    }

    @PreDestroy
    public void destroy() {
        log.info("NumberService destroyed");
    }
}
