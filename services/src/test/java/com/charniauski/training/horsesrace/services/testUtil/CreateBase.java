package com.charniauski.training.horsesrace.services.testUtil;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Andre on 07.11.2016.
 */
public class CreateBase {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        Resource resourceCreate = new FileSystemResource("horses_race_postgres_create.sql");
        Resource resourceCreateData = new FileSystemResource("insert_data_base.sql");
        Resource resourceDrop = new FileSystemResource("horses_race_postgres_drop.sql");
        try {
            ScriptUtils.executeSqlScript(connection, resourceDrop);
        } catch (ScriptStatementFailedException e) {
            e.printStackTrace();
        }
        ScriptUtils.executeSqlScript(connection, resourceCreate);
        ScriptUtils.executeSqlScript(connection, resourceCreateData);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
