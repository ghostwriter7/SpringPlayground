package com.rozplochowski.aspectorientedprogramming.service;

import com.rozplochowski.aspectorientedprogramming.aop.LoggingRequired;
import org.springframework.stereotype.Service;

@Service
public class StandardUnitCalculator implements UnitCalculator {

    @Override
    @LoggingRequired
    public double kilogramToPound(double kilogram) {
        var result = kilogram * 2.20462;
        IO.println("%.2f kg = %.2f lbs".formatted(kilogram, result));
        return result;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        var result = kilometer * 0.621371;
        IO.println("%.2f km = %.2f mi".formatted(kilometer, result));
        return result;
    }
}
