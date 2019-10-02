package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao extends AbstractDao implements UserDaoInterface {
    @Override
    public User create(UserDto userDto) throws FailedToSaveUserException {
        User user = new User(userDto.getFirstname(), userDto.getMiddlename(), userDto.getLastname(), userDto.getBirthdate());
        insertRow(user);

        return user;
    }

    protected void insertRow(User user) throws FailedToSaveUserException {
        try (Session session = getSessionFactory().openSession();) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            throw new FailedToSaveUserException("Неудача при попытке сохранения пользователя", e);
        }
    }
}
