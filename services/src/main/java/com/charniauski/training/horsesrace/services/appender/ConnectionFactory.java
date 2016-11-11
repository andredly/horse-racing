package com.charniauski.training.horsesrace.services.appender;

/**
 * Created by ivc4 on 09.11.2016.
 */


import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    private final DataSource dataSource;

    private ConnectionFactory() {

        Properties properties=new Properties();
        try {
            URL file=this.getClass().getClassLoader().getResource("db.properties");
            assert file != null;
            properties.load(new FileInputStream(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<>();

//        BoneCPDataSource boneCPDataSource=new BoneCPDataSource();
//        boneCPDataSource.setDriverClass("org.postgresql.Driver");
//        boneCPDataSource.setUser("postgres");
//        boneCPDataSource.setPassword("root");
//        boneCPDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

        DriverManagerConnectionFactory connectionFactory = new CustomDriverConnectionFactory(properties);
//        PoolingDataSource poolingDataSource = new PoolingDataSource();
//        poolingDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        poolingDataSource.setServerName("localhost");
//        poolingDataSource.setPortNumber(5432);
//        poolingDataSource.setUser("postgres");
//        poolingDataSource.setPassword("root");
//        poolingDataSource.setCharset("UTF8");
//        poolingDataSource.setDatabaseName("postgres");
//        poolingDataSource.setCurrentSchema("public");

        new PoolableConnectionFactory(
                connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );

        this.dataSource = new PoolingDataSource(pool);
//        this.dataSource=new PoolingDataSource(pool);
//        this.dataSource=boneCPDataSource;
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }

}