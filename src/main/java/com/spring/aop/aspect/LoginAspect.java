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
    @Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
    private void forGetPackage(){}
    @Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
    private void forSetPackage(){}
    @Pointcut("forDaoPackage()&&!(forGetPackage()||forSetPackage())")
    private void noGettersAndSetters(){}
    @Before("noGettersAndSetters()")
    public  void beforeAddAccountAdvice(){
        System.out.println("==========Before add account advice==========");
    }
}
