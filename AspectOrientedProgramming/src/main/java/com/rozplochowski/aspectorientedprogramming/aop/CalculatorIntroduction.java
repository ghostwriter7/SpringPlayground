package com.rozplochowski.aspectorientedprogramming.aop;

import com.rozplochowski.aspectorientedprogramming.service.MaxCalculator;
import com.rozplochowski.aspectorientedprogramming.service.MinCalculator;
import com.rozplochowski.aspectorientedprogramming.service.SimpleMaxCalculator;
import com.rozplochowski.aspectorientedprogramming.service.SimpleMinCalculator;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalculatorIntroduction {

    @DeclareParents(
            value = "com.rozplochowski.aspectorientedprogramming.service.StandardArithmeticCalculator",
            defaultImpl = SimpleMaxCalculator.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "com.rozplochowski.aspectorientedprogramming.service.StandardArithmeticCalculator",
            defaultImpl = SimpleMinCalculator.class
    )
    public MinCalculator minCalculator;

}
