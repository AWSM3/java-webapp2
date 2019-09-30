package com.lanit.webapp2.factory;

import com.lanit.webapp2.repository.UserRepository;
import com.lanit.webapp2.repository.UserRepositoryInterface;

import java.sql.Connection;

public class UserRepositoryFactory extends AbstractFactory {
    @Override
    public UserRepositoryInterface build() {
        Connection connection = (Connection) this.context.getAttribute(Connection.class.getSimpleName());
        UserRepository repository = new UserRepository();
        repository.setConnection(connection);

        return repository;
    }
}
