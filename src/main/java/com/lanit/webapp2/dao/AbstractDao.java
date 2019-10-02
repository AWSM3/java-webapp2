package com.lanit.webapp2.dao;

import com.lanit.webapp2.util.Hibernate;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;

public class AbstractDao {
    private SessionFactory sessionFactory;

    public EntityManager getEntityManager() {
        return Hibernate.getEntityManager();
    }
}
