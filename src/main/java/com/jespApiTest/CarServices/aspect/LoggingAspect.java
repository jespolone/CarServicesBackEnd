package com.jespApiTest.CarServices.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 *
 * Questo aspect traccia le Request ricevute dai metodi presenti
 * nei rest controller e le relative Response
 *
 * @author Iluca Elvin
 *
 */
@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Around("execution(* com.jespApiTest.CarServices..*Controller.*(..)))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Object value = null;
        log.info("Invoking {} ({})", methodSignature.getName(), proceedingJoinPoint.getArgs());
        value = proceedingJoinPoint.proceed();
        log.info("Call to {} ({}) returned {}", methodSignature.getName(), proceedingJoinPoint.getArgs(), value);
        return value;
    }
}
