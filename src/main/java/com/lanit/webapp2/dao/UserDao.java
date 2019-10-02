package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

public class UserDao extends AbstractDao implements UserDaoInterface {
    @Override
    public User create(UserDto userDto) throws FailedToSaveUserException {
        User user = new User(userDto.getFirstname(), userDto.getMiddlename(), userDto.getLastname(), userDto.getBirthdate());
        insertRow(user);

        return user;
    }

    protected void insertRow(User user) throws FailedToSaveUserException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new FailedToSaveUserException("Неудача при попытке сохранения пользователя", e);
        } finally {
            em.close();
        }
    }
}
