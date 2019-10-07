package com.lanit.webapp2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {
    private static final String PERSISTENCE_UNIT_NAME = "local-persistence";
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager() {
        try {
            return entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            System.err.println(String.format("Ошибка при инициализации менеджера сущностей Hibernate: %s", e.getMessage()));
            throw new ExceptionInInitializerError(e);
        }
    }
}
