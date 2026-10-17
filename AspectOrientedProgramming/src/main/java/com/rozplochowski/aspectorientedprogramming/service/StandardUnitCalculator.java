package com.rozplochowski.aspectorientedprogramming.service;

public class StandardUnitCalculator implements UnitCalculator {
    @Override
    public double kilogramToPound(double kilogram) {
        var result = kilogram * 2.20462;
        IO.println("%f kg = %f lbs".formatted(kilogram, result));
        return result;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        var result = kilometer * 0.621371;
        IO.println("%f km = %f mi".formatted(kilometer, result));
        return result;
    }
}
