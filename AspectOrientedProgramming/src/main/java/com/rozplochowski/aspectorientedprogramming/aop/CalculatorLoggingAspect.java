package com.rozplochowski.aspectorientedprogramming.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Slf4j
public class CalculatorLoggingAspect {

    @Pointcut("execution(* com.rozplochowski.aspectorientedprogramming.service.*.*(..))")
    private void calculatorServiceMethods() {}

    @Before("calculatorServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();

        log.info("This object (proxy) is {}", joinPoint.getThis());
        log.info("Target object (original) is {}", joinPoint.getTarget());
        log.info("Join point's kind is {}", joinPoint.getKind());
        log.info("Signature declaring type is {}", joinPoint.getSignature().getDeclaringType());

        var args = Arrays.toString(joinPoint.getArgs());
        log.info("The method {} begins with arguments {}", name, args);
    }

    @After("calculatorServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        log.info("The method {} ends", name);
    }

    @AfterReturning(
            pointcut = "calculatorServiceMethods()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Double result) {
        var name = joinPoint.getSignature().getName();
        log.info("The method {} returns {}", name, result);
    }

    @AfterThrowing(
            pointcut = "calculatorServiceMethods()",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        var name = joinPoint.getSignature().getName();
        log.error("The method {} throws {}", name, ex.getMessage());
    }

    @Around("calculatorServiceMethods()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        var name = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("The method {} begins with arguments {}", name, args);

        try {
            var result = joinPoint.proceed();
            log.info("The method {} ends with value {}", name, result);
            return result;
        } catch (Throwable ex) {
            log.error("The method {} throws {}", name, ex.getMessage());
            throw ex;
        }
    }
}
