package com.spring.aop.aspect;

import com.spring.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class AddAccountAspect {
    @Around("execution(* com.spring.aop.service.*.getFortune())")

    public Object aroundAdvise(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime)/1000;
        System.out.println("Duration: " + duration);
    return result;
    }

    @AfterThrowing(
            pointcut = "(execution(* com.spring.aop.dao.AccountDAO.getAccount(..)))",
            throwing = "exc")
    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
        System.out.println("AfterThrowing " + joinPoint.getSignature().getName());
        System.out.println("The exception is " + exc);
    }


    @AfterReturning(
            pointcut = "(execution(* com.spring.aop.dao.AccountDAO.getAccount()))",
            returning = "result"

    )
    public void doAfterReturning(JoinPoint joinPoint, List<Account> result) {
        System.out.println("+++++++After+++++++");
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println("Result " + result);

        changeTheNamesToUpperCase(result);
        for (Account account : result) {
            System.out.print(account.getName() + "  ");
        }
    }

    private void changeTheNamesToUpperCase(List<Account> result) {
        for (Account a : result) {
            a.setName(a.getName().toUpperCase());
        }
    }


    @Before("com.spring.aop.aspect.PointcutDeclarations.forDaoPackage()")

    public void beforeAddAccountAdvice() {
        System.out.println("==========Before add account advice==========");
    }
}
