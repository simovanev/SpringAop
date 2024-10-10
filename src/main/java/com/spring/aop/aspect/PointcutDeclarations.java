package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class PointcutDeclarations {

    @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
    public void forGetPackage(){}
    @Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
    public void forSetPackage(){}
    @Pointcut("forDaoPackage()&&!(forGetPackage()||forSetPackage())")
    public void noGettersAndSetters(){}
}
