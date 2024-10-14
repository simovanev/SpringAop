package com.spring.aop.aspect;

import com.spring.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class AddAccountAspect {
    @AfterReturning(
            pointcut = "(execution(* com.spring.aop.dao.AccountDAO.getAccounts()))",
            returning = "result"

    )
    public void doAfterReturning(JoinPoint joinPoint, List<Account> result){
        System.out.println("+++++++After+++++++");
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println("Result "+result);

        changeTheNamesToUpperCase(result);
        for (Account account : result) {
            System.out.print(account.getName()+"  ");
        }
    }

    private void changeTheNamesToUpperCase(List<Account> result) {
        for(Account a : result) {
            a.setName(a.getName().toUpperCase());
        }
    }


    @Before("com.spring.aop.aspect.PointcutDeclarations.forDaoPackage()")

    public void beforeAddAccountAdvice() {
        System.out.println("==========Before add account advice==========");
    }
}
