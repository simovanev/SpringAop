package com.spring.aop.dao;

import com.spring.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String sourceCodename;

    public String getName() {
        System.out.println(getClass().getSimpleName() + " getName");
        return name;
    }

    @Override
    public List<Account> getAccounts() {
        return getAccount(false);
    }

    @Override
    public List<Account> getAccount(boolean condition) {
        if (condition) {
            throw new RuntimeException("Exception activated...");
        }
        Account a1 = new Account("Pesho", "bronze");
        Account a2 = new Account("Gosho", "silver");
        Account a3 = new Account("Ivan", "Gold");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        return accounts;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + " setName");
        this.name = name;
    }

    public String getSourceCodename() {
        System.out.println(getClass().getSimpleName() + " getSourceCodename");
        return sourceCodename;
    }

    public void setSourceCodename(String sourceCodename) {
        System.out.println(getClass().getSimpleName() + " setSourceCodename");
        this.sourceCodename = sourceCodename;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + " Do the work!");
    }
}
