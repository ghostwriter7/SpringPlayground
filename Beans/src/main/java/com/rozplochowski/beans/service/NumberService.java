package com.rozplochowski.beans.service;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NumberService {

    private final List<Number> numbers; // 42 & 21.0 as defined in config.NumbersConfig

    // numbers by bean name (e.g. "meaningOfLife" -> 42)
    private final Map<String, Number> numbersByName;
    private final ObjectProvider<Short> shortObjectProvider;

    // meaningOfLife due to @Primary annotation
    private final Number mostImportantNumber;

    private final Number luckyNumber;

    public NumberService(List<Number> numbers,
                         Map<String, Number> numbersByName,
                         ObjectProvider<Short> shortObjectProvider,
                         Number mostImportantNumber,
                         @Qualifier("luckyNumber") Number luckyNumber) {
        this.numbers = numbers;
        this.numbersByName = numbersByName;
        this.shortObjectProvider = shortObjectProvider;
        this.mostImportantNumber = mostImportantNumber;
        this.luckyNumber = luckyNumber;
    }

    @PostConstruct
    public void init() {
        IO.println("ObjectProvider for Short provided: " + shortObjectProvider.getIfUnique());

        IO.println("Most important number: " + mostImportantNumber);
        IO.println("Lucky number: " + luckyNumber);
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
        IO.println(numbers);
    }

    public void printNumbersIndex() {
        IO.println(numbersByName);
    }

}
