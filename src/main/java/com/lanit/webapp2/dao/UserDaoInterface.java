package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import com.lanit.webapp2.exception.UserNotFoundException;

import java.util.List;

public interface UserDaoInterface extends DaoInterface {
    public User create(RequestUserDto user) throws FailedToSaveUserException;

    public User get(String userId) throws UserNotFoundException;

    public List<User> getList();
}
