package com.lanit.webapp2.listener;

import com.lanit.webapp2.factory.DatabaseConnectionFactory;
import com.lanit.webapp2.factory.FactoryInterface;
import com.lanit.webapp2.factory.UserRepositoryFactory;
import com.lanit.webapp2.mapper.UserDtoMapper;
import com.lanit.webapp2.repository.UserRepositoryInterface;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            setupContext(servletContextEvent.getServletContext());
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    private void setupContext(ServletContext context) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /** коннект к бд */
        context.setAttribute(Connection.class.getSimpleName(), getFactory(DatabaseConnectionFactory.class, context).build());
        /** репозиторий юзеров */
        context.setAttribute(UserRepositoryInterface.class.getSimpleName(), getFactory(UserRepositoryFactory.class, context).build());
        /** маппер */
        context.setAttribute(UserDtoMapper.class.getSimpleName(), new UserDtoMapper());
    }


    private FactoryInterface getFactory(Class factoryClass, ServletContext context) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Constructor constructor = factoryClass.getConstructor();
        FactoryInterface factoryInstance = (FactoryInterface) constructor.newInstance();
        factoryInstance.setContext(context);

        return factoryInstance;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
