package com.lanit.webapp2.dao;

import com.lanit.webapp2.util.Hibernate;
import org.hibernate.SessionFactory;

public class AbstractDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return Hibernate.getSessionFactory();
    }
}
