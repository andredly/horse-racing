package com.charniauski.training.horsesrace.services.testUtil;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Andre on 07.11.2016.
 */
public class CreateBase {

    public void init() {

        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String DB_URL = properties.getProperty("jdbc.url");
        final String USER = properties.getProperty("jdbc.username");;
        final String PASS = properties.getProperty("jdbc.password");;

        try {
//            Class.forName("org.postgresql.Driver");
            Class.forName(properties.getProperty("jdbc.driver"));
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
        Resource resourceCreate = new FileSystemResource("src/test/resources/horses_race_postgres_create.sql");
        Resource resourceCreateData = new FileSystemResource("src/test/resources/insert_data_base.sql");
        Resource resourceDrop = new FileSystemResource("src/test/resources/horses_race_postgres_drop.sql");
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
