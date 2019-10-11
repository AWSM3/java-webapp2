package com.lanit.webapp2.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DatabaseMigration {
    @PersistenceContext
    protected EntityManager em;

    public void migrate() {
        Query query = em.createNativeQuery(getSql());
        query.executeUpdate();
    }

    private static String getSql() {
        ClassLoader classLoader = DatabaseMigration.class.getClassLoader();
        String file = ResourceBundle.getBundle("hibernate").getString("db.migration_file");

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
