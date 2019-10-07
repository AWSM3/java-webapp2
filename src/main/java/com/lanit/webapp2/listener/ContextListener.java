package com.lanit.webapp2.listener;

import com.lanit.webapp2.factory.DatabaseConnectionFactory;
import com.lanit.webapp2.factory.FactoryInterface;
import com.lanit.webapp2.mapper.RequestAddressDtoMapper;
import com.lanit.webapp2.mapper.RequestUserDtoMapper;
import com.lanit.webapp2.util.DatabaseMigration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {
    protected ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        context = servletContextEvent.getServletContext();

        try {
            setupContext();
            setupDatabase();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }


    private void setupContext() throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /** коннект к бд */
        context.setAttribute(Connection.class.getSimpleName(), getFactory(DatabaseConnectionFactory.class, context).build());
        /** маппер юзеров */
        context.setAttribute(RequestUserDtoMapper.class.getSimpleName(), new RequestUserDtoMapper());
        /** маппер адресов */
        context.setAttribute(RequestAddressDtoMapper.class.getSimpleName(), new RequestAddressDtoMapper());
    }

    private void setupDatabase() throws FileNotFoundException, SQLException {
        DatabaseMigration.initDatabaseJdbc((Connection) context.getAttribute(Connection.class.getSimpleName()));
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
