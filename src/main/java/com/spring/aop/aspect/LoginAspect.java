package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
    private void forDaoPackage(){}
    @Before("forDaoPackage()")
    public  void beforeAddAccountAdvice(){
        System.out.println("Before add account advice");
    }
}
