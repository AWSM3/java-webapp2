package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;

public interface UserDaoInterface {
    public User create(UserDto user) throws FailedToSaveUserException;
}
