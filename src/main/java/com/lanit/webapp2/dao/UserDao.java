package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao extends AbstractDao implements UserDaoInterface {
    @Override
    public User create(UserDto userDto) throws FailedToSaveUserException {
        User user = new User(userDto.getFirstname(), userDto.getMiddlename(), userDto.getLastname(), userDto.getBirthdate());
        insertRow(user);

        return user;
    }

    protected void insertRow(User user) throws FailedToSaveUserException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
            statement.setString(1, user.getId().toString());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getMiddlename());
            statement.setString(4, user.getLastname());
            statement.setString(5, user.getBirthdate().toString());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            throw new FailedToSaveUserException("Неудача при попытке сохранения пользователя", e);
        }
    }
}
