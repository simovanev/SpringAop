package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    @Before("execution(public void addAccount())")
    public  void beforeAddAccountAdvice(){
        System.out.println("Before add account advice");
    }
}
