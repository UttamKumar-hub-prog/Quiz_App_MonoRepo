package com.wipro.uttam.quizappmonorepo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.wipro.uttam.quizappmonorepo.servicess.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🔹 Before Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.wipro.uttam.quizappmonorepo.servicess.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ After Method: " + joinPoint.getSignature().getName() + " | Returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.wipro.uttam.quizappmonorepo.servicess.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("❌ Exception in Method: " + joinPoint.getSignature().getName() + " | Exception: " + exception.getMessage());
    }
}
