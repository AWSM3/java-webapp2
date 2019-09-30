package com.lanit.webapp2.repository;

import java.sql.Connection;

public class AbstractRepository {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
