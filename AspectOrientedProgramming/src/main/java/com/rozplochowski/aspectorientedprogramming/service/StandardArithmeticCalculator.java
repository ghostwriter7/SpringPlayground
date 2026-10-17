package com.rozplochowski.aspectorientedprogramming.service;

import org.springframework.stereotype.Service;

@Service
class StandardArithmeticCalculator implements ArithmeticCalculator {
    @Override
    public double add(double a, double b) {
        var result = a + b;
        IO.println("%.2f + %.2f = %.2f".formatted(a, b, result));
        return result;
    }

    @Override
    public double subtract(double a, double b) {
        var result = a - b;
        IO.println("%.2f - %.2f = %.2f".formatted(a, b, result));
        return result;
    }

    @Override
    public double multiply(double a, double b) {
        var result = a * b;
        IO.println("%.2f * %.2f = %.2f".formatted(a, b, result));
        return result;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }

        var result = a / b;
        IO.println("%.2f / %.2f = %.2f".formatted(a, b, result));
        return result;
    }
}
