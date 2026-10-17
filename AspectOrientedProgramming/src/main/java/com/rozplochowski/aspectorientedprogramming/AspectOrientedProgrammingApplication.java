package com.rozplochowski.aspectorientedprogramming;

import com.rozplochowski.aspectorientedprogramming.config.Config;
import com.rozplochowski.aspectorientedprogramming.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectOrientedProgrammingApplication {

    static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(Config.class)) {
            var calculator = ctx.getBean(ArithmeticCalculator.class);
            calculator.add(1, 2);
            calculator.subtract(10, 5);
            calculator.multiply(3, 4);
            calculator.divide(10, 2);

            var unitCalculator = ctx.getBean(UnitCalculator.class);
            unitCalculator.kilogramToPound(25);
            unitCalculator.kilometerToMile(100);

            ((MinCalculator) calculator).min(10, 5);
            ((MaxCalculator) calculator).max(10, 5);

            IO.println("Arithmetic Calculator has been used %d times".formatted(((Counter) calculator).getValue()));
            IO.println("Unit Calculator has been used %d times".formatted(((Counter) unitCalculator).getValue()));

//            calculator.divide(10, 0);
        }
    }

}
