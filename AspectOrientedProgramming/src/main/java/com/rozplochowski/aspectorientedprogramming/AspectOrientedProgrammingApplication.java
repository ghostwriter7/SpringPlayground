package com.rozplochowski.aspectorientedprogramming;

import com.rozplochowski.aspectorientedprogramming.config.Config;
import com.rozplochowski.aspectorientedprogramming.service.ArithmeticCalculator;
import com.rozplochowski.aspectorientedprogramming.service.MaxCalculator;
import com.rozplochowski.aspectorientedprogramming.service.MinCalculator;
import com.rozplochowski.aspectorientedprogramming.service.UnitCalculator;
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

            calculator.divide(10, 0);
        }
    }

}
