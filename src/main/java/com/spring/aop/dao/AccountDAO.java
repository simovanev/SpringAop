package com.spring.aop.dao;

public interface AccountDAO {
    void addAccount();

    void setSourceCodename(String sourceCodename);
    String getSourceCodename();
    void setName(String name);
    String getName();
}
