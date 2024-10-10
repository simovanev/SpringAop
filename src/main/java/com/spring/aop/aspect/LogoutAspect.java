package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class LogoutAspect {
    @Before("com.spring.aop.aspect.PointcutDeclarations.noGettersAndSetters()")
    public void afterLogin(){
        System.out.println("==========After login==========");
    }
}
