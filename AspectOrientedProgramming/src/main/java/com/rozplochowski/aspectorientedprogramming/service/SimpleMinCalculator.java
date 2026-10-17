package com.rozplochowski.aspectorientedprogramming.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleMinCalculator implements MinCalculator {

    @Override
    public double min(double a, double b) {
        var result = Math.min(a, b);
        log.info("Given values: a={}, b={}, min value is {}", a, b, result);
        return result;
    }
}
