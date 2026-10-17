package com.rozplochowski.aspectorientedprogramming.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class CalculatorValidationAspect {

    @Around("execution(* com.rozplochowski.aspectorientedprogramming.service.*.*(double, double))")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
        var secondArg = joinPoint.getArgs()[1];

        if ((Double) secondArg <= 0) {
            throw new IllegalArgumentException("Second argument must be non-negative");
        }

        return joinPoint.proceed();
    }

}
