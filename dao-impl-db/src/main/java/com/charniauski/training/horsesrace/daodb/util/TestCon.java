package com.charniauski.training.horsesrace.daodb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ivc4 on 09.11.2016.
 */
public class TestCon {

    public static void main(String[] args) {
        try {
        Connection databaseConnection = ConnectionFactory.getDatabaseConnection();
        System.out.println(databaseConnection);

            PreparedStatement preparedStatement = databaseConnection.prepareStatement("INSERT INTO logging (EVENT_DATE,level,logger,msg,throwable) VALUES ('2016-11-09 12:11:40.588000 +03:00:00','ERROR','com.charniauski.training.horsesrace.daodb.impl.AbstractDao','Not found entity','org.springframework.dao.EmptyResultDataAccessException');");
            preparedStatement.executeUpdate();
            boolean execute = preparedStatement.execute();

            System.out.println(execute);
        } catch(SQLException current) {
            current.printStackTrace();
            System.out.println("================ {{{");

        }
    }
}
