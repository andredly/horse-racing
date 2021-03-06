package com.charniauski.training.horsesrace.services.testutil;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Andre on 07.11.2016.
 */
@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class RelationalBD implements BaseCreator {
    @Override
    public void createRelationDB() {

        Properties properties = new Properties();
        try {
            URL file = this.getClass().getClassLoader().getResource("db.properties");
            assert file != null;
            properties.load(new FileInputStream(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String DB_URL = properties.getProperty("jdbc.url");
        final String USER = properties.getProperty("jdbc.username");
        final String PASS = properties.getProperty("jdbc.password");

//        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
//        SchemaNameAwareBasicDataSource bean = springContext.getBean(SchemaNameAwareBasicDataSource.class);

        Connection connection;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
//        try {
//            connection = bean.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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

    @Override
    public void createXMLDB() {

    }
}
