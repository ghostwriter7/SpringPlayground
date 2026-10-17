package com.rozplochowski.aspectorientedprogramming.aop;

import com.rozplochowski.aspectorientedprogramming.service.*;
import org.aspectj.lang.annotation.After;
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

    @DeclareParents(
            value = "com.rozplochowski.aspectorientedprogramming.service.Standard*Calculator",
            defaultImpl = SimpleCounter.class
    )
    public Counter counter;

    // use `this(..)` not `target(..)` as Counter is implemented by the proxy object only!
    @After(value = "execution(* com.rozplochowski.aspectorientedprogramming.service.*Calculator.*(..)) && this(counter)", argNames = "counter")
    public void incrementCounter(Counter counter) {
        counter.increment();
    }

}
