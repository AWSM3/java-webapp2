package com.lanit.webapp2.factory;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnectionFactory extends AbstractFactory {
    @Override
    public Connection build() {
        ResourceBundle databaseResource = ResourceBundle.getBundle("db");

        String dbURL = databaseResource.getString("db.url");
        String dbName = databaseResource.getString("db.name");
        String dbUsername = databaseResource.getString("db.user");
        String dbPassword = databaseResource.getString("db.password");
        String dbDriver = databaseResource.getString("db.driver");

        try {
            Class.forName(dbDriver);

            return DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
            return null;
        }
    }
}
