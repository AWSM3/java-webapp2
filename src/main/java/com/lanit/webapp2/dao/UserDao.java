package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import com.lanit.webapp2.exception.UserNotFoundException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserDao extends AbstractDao implements UserDaoInterface {
    @Override
    public User create(RequestUserDto requestUserDto) throws FailedToSaveUserException {
        User user = new User(requestUserDto.getFirstname(), requestUserDto.getMiddlename(), requestUserDto.getLastname(), requestUserDto.getBirthdate());
        try {
            insertRow(user);
        } catch (Exception e) {
            throw new FailedToSaveUserException("Неудача при попытке сохранения пользователя", e);
        }


        return user;
    }

    public User get(String userId) throws UserNotFoundException {
        EntityManager em = getEntityManager();
        try {
            User user = em.find(User.class, UUID.fromString(userId));
            if (null == user) {
                throw new UserNotFoundException("Пользователь не был найден.");
            }

            return user;
        } finally {
            em.close();
        }
    }

    public List<User> getList() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> rootEntry = criteriaQuery.from(User.class);
            criteriaQuery.select(rootEntry);

            return em.createQuery(criteriaQuery).getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> getListWithFetchingLazy() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> rootEntry = criteriaQuery.from(User.class);
            rootEntry.fetch("addresses", JoinType.LEFT);
            criteriaQuery.distinct(true);
            criteriaQuery.select(rootEntry);

            return em.createQuery(criteriaQuery).getResultList();
        } finally {
            em.close();
        }
    }
}
