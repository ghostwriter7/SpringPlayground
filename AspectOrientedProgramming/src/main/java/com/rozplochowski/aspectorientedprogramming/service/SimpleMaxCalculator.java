package com.rozplochowski.aspectorientedprogramming.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleMaxCalculator implements MaxCalculator {
    @Override
    public double max(double a, double b) {
        var result = Math.max(a, b);
        log.info("Given values: a={}, b={}, max value is {}", a, b, result);
        return result;
    }
}
