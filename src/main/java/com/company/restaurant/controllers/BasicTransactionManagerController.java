package com.company.restaurant.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by Yevhen on 07.06.2016.
 */
public class BasicTransactionManagerController {
    private final static String APPLICATION_CONTEXT_NAME = "restaurant-controller-application-context.xml";

    private PlatformTransactionManager txManager;

    protected static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_NAME);

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }
}
