package com.lanit.webapp2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Hibernate {
    private static final String PERSISTENCE_UNIT_NAME = "local-persistence";

    private static EntityManager entityManager;

    static {
        createEntityManager();
    }

    private static EntityManager createEntityManager() {
        try {
            return entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        } catch (Exception e) {
            System.err.println(String.format("Ошибка при инициализации менеджера сущностей Hibernate: %s", e.getMessage()));
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager.isOpen() ? entityManager : createEntityManager();
    }
}
