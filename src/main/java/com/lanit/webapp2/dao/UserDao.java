package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import com.lanit.webapp2.exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class UserDao extends AbstractDao implements UserDaoInterface {
    @Override
    public User create(UserDto userDto) throws FailedToSaveUserException {
        User user = new User(userDto.getFirstname(), userDto.getMiddlename(), userDto.getLastname(), userDto.getBirthdate());
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
            TypedQuery<User> query = em.createQuery(criteriaQuery);

            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
