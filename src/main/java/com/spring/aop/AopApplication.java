package com.spring.aop;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, TrafficFortuneService
                                               theTrafficFortuneService) {
        return runner -> {
            //doTheJob(theAccountDAO);
            //afterReturnAdvise(theAccountDAO);
            //throwExceptionMethod(theAccountDAO);
            takeTheFortune(theTrafficFortuneService);
        };
    }

    private void takeTheFortune(TrafficFortuneService theTrafficFortuneService) {
        theTrafficFortuneService.getFortune();
    }

    private void throwExceptionMethod(AccountDAO theAccountDAO) {
        boolean condition = true;
        List<Account> account = null;
        try {
            account = theAccountDAO.getAccount(condition);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void afterReturnAdvise(AccountDAO theAccountDAO) {
        System.out.println("-----------");
        System.out.println(theAccountDAO.getAccounts());
        System.out.println("-----------");
    }

    private void doTheJob(AccountDAO theAccountDAO) {
        theAccountDAO.addAccount();
        theAccountDAO.getName();
        theAccountDAO.getSourceCodename();
        theAccountDAO.setName("Name");
        theAccountDAO.setSourceCodename("Source Codename");
    }
}


