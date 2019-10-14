package com.lanit.webapp2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao {
    @PersistenceContext
    protected EntityManager em;

    protected void insertRow(Object object) {
        try {
            em.persist(object);
            em.flush();
        } finally {
            em.close();
        }
    }
}
