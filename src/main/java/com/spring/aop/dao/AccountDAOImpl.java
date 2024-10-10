package com.spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String sourceCodename;

    public String getName() {
        System.out.println(getClass().getSimpleName()+" getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName()+" setName");
        this.name = name;
    }

    public String getSourceCodename() {
        System.out.println(getClass().getSimpleName()+" getSourceCodename");
        return sourceCodename;
    }

    public void setSourceCodename(String sourceCodename) {
        System.out.println(getClass().getSimpleName()+" setSourceCodename");
        this.sourceCodename = sourceCodename;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName()+" Do the work!");
    }
}
