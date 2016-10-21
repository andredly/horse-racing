package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivc4 on 21.10.2016.
 */
public class AbstractDao<T, PK> implements GenericDao<T, PK>{

    private DataSource dataSource;

    @Override
    public T get(PK id) {

        return null;
    }

    @Override
    public void insert(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(PK id) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }


    public Connection getConnection (String login, String password){
        Connection connection=null;
        try {
            connection=dataSource.getConnection(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection (){
        Connection connection=null;
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
