package com.lanit.webapp2.factory;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory extends AbstractFactory {
    @Override
    public Connection build() {
        String dbURL = "jdbc:mysql://remotemysql.com:3306/";
        String dbName = "8RWTedOitf";
        String dbUsername = "8RWTedOitf";
        String dbPassword = "weuczZX4mS";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
            return null;
        }
    }
}
