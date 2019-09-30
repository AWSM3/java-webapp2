package com.lanit.webapp2.dao;

import java.sql.Connection;

public class AbstractDao {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
