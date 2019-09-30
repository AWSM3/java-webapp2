package com.lanit.webapp2.factory;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dao.UserDaoInterface;

import java.sql.Connection;

public class UserDaoFactory extends AbstractFactory {
    @Override
    public UserDaoInterface build() {
        Connection connection = (Connection) this.context.getAttribute(Connection.class.getSimpleName());
        UserDao dao = new UserDao();
        dao.setConnection(connection);

        return dao;
    }
}
