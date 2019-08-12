package org.item.jurisdiction.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(1)
@Component
public class LoggerAspect {

    @Pointcut("execution(* org.item.jurisdiction.service.Impl.*..*(..))")
    public void point() {
    }

    @Before("point()")
    public void beforMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("this method " + methodName + " begin. param<" + args + ">");

    }

    @After("point()")
    public void afterMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("this method " + methodName + " end.");

    }
}
