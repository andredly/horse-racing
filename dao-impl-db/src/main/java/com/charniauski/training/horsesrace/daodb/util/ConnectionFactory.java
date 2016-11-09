package com.charniauski.training.horsesrace.daodb.util;

/**
 * Created by ivc4 on 09.11.2016.
 */

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.postgresql.jdbc2.optional.ConnectionPool;
import org.postgresql.jdbc2.optional.PoolingDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;


public class ConnectionFactory {
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    private final DataSource dataSource;

    private ConnectionFactory() {



//        Properties properties=new Properties();
//        try {
//            properties.load(new FileInputStream("src/main/resources/db.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//                try {
////            Class.forName("org.postgresql.Driver");
//            Class.forName(properties.getProperty("jdbc.driver"));
//        } catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
//            e.printStackTrace();
//        }
//        GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>();
//        ConnectionPool pool=new ConnectionPool();
//
//        pool.setUrl(properties.getProperty("jdbc.url"));
//        pool.setUser("jdbc.username");
//        pool.setPassword("jdbc.password");
//        final String DB_URL = properties.getProperty("jdbc.url");
//        final String USER = properties.getProperty("jdbc.username");;
//        final String PASS = properties.getProperty("jdbc.password");;
//
//        Properties properties = new Properties();
//        properties.setProperty("user", "logging");
//        properties.setProperty("password", "abc123"); // or get properties from some configuration file
//
//        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
//                "jdbc:mysql://example.org:3306/exampleDb", properties
//        );

//        DriverManagerConnectionFactory connectionFactory = new CustomDriverConnectionFactory(properties);
        PoolingDataSource poolingDataSource = new PoolingDataSource();
//        poolingDataSource.setUrl(properties.getProperty("jdbc.url"));
        poolingDataSource.setServerName("localhost");
        poolingDataSource.setPortNumber(5432);
        poolingDataSource.setUser("postgres");
        poolingDataSource.setPassword("root");
        poolingDataSource.setCharset("UTF8");
        poolingDataSource.setDatabaseName("postgres");
        poolingDataSource.setCurrentSchema("public");
//        new PoolableConnectionFactory(
//                connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
//        );

//        this.dataSource = new PoolingDataSource(pool);
//        this.dataSource=new PoolingDataSource(pool);
        this.dataSource=poolingDataSource;
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }

}