package com.lanit.webapp2.factory;

import javax.servlet.ServletContext;

public abstract class AbstractFactory implements FactoryInterface {
    protected ServletContext context;

    @Override
    public void setContext(ServletContext context) {
        this.context = context;
    }
}
