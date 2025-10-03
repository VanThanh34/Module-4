package com.codegym.c0525g1_spring_boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

    @After(value = " execution( * com.codegym.c0525g1_spring_boot.controller.StudentController.getAllStudents(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Hành vi người dùng vừa sử dụng là: "+ joinPoint.getSignature().getName());
    }
}
