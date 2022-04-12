package com.chienle.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class SachAspect {
    private static Integer soNguoi = 0;

    @AfterReturning(pointcut = "execution(public * com.chienle.controller.SachController.muonSach(..)) || " +
            "execution(public * com.chienle.controller.SachController.traSach(..))")
    public void logChangeBookStatus(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Method name:" + methodName);
        System.err.println("Args:" + args);
    }

    @AfterReturning(pointcut = "execution(public * com.chienle.controller.SachController.*(..))")
    public void logHistory(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        soNguoi++;
        System.out.println("Number person use: " + soNguoi);
        System.err.println("Method name:" + methodName);
        System.err.println("Args:" + args);
    }
}
