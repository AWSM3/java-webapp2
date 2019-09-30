package com.lanit.webapp2.factory;

import javax.servlet.ServletContext;

public interface FactoryInterface {
    public Object build();

    public void setContext(ServletContext context);
}
