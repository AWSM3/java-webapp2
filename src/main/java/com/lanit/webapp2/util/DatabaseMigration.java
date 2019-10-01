package com.lanit.webapp2.util;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DatabaseMigration {
    public static void initDatabaseJdbc(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(getSql());
        statement.close();
    }

    private static String getSql() {
        ClassLoader classLoader = DatabaseMigration.class.getClassLoader();
        String file = ResourceBundle.getBundle("db").getString("db.migration_file");

        StringBuilder builder;
        try (Scanner s = new Scanner(classLoader.getResourceAsStream(file))) {
            builder = new StringBuilder();
            while (s.hasNextLine()) {
                builder.append(s.nextLine());
            }
        }

        return builder.toString();
    }
}
