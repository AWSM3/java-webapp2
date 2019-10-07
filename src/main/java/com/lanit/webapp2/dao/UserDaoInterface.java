package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;

public interface UserDaoInterface extends DaoInterface {
    public User create(RequestUserDto user) throws FailedToSaveUserException;
}
