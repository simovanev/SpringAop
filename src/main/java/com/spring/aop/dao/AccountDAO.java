package com.spring.aop.dao;

import com.spring.aop.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();

    void setSourceCodename(String sourceCodename);
    String getSourceCodename();
    void setName(String name);
    String getName();
    List<Account> getAccounts();

    List<Account> getAccount(boolean condition);
}
