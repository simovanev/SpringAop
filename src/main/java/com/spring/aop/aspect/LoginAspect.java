package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoginAspect {


    @Before("com.spring.aop.aspect.PointcutDeclarations.noGettersAndSetters()")
    public void beforeLogin() {
        System.out.println("==========Before login==========");
    }

}
