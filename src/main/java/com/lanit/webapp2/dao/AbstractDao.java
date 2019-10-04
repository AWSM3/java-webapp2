package com.lanit.webapp2.dao;

import com.lanit.webapp2.util.Hibernate;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class AbstractDao {
    private SessionFactory sessionFactory;

    public EntityManager getEntityManager() {
        return Hibernate.getEntityManager();
    }

    protected void insertRow(Object object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
