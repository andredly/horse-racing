
import org.postgresql.Driver;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Andre on 16.10.2016.
 */
public class TestSql {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) throws SQLException {
//        Driver driver=new Driver();
//        System.out.println(driver.getClass());

//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
//            e.printStackTrace();
//            return;
//
//        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user\"(first_name, last_name,gender,date,address)" +
                "VALUES(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, "Rok");
        preparedStatement.setString(2, "Fenst");
        preparedStatement.setString(3, "m");
        preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()), Calendar.getInstance());
        preparedStatement.setString(5, "Gotem");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        while (generatedKeys.next()) {
            System.out.println(generatedKeys.getInt(1));
        }


        PreparedStatement preparedStatementUpdate = connection.prepareStatement
                ("UPDATE \"user\" SET first_name=?, last_name=?,gender=?,date=?,address=? WHERE id=?");

        preparedStatementUpdate.setString(1, "Ro");
        preparedStatementUpdate.setString(2, "Fet1");
        preparedStatementUpdate.setString(3, "f");
        preparedStatementUpdate.setDate(4, new java.sql.Date(new Date().getTime()), Calendar.getInstance());
        preparedStatementUpdate.setString(5, "Gem1");
        preparedStatementUpdate.setInt(6, 4);
        preparedStatementUpdate.executeUpdate();
        preparedStatement.close();
        preparedStatementUpdate.close();


        Statement statementSelect = connection.createStatement();
        ResultSet resultSet = statementSelect.executeQuery("SELECT last_name, first_name, gender, address, date FROM \"user\" us" +
                " JOIN account ac ON (us.id=ac.id) LEFT JOIN security_level sl ON (ac.security_level_id = sl.id)");
        while (resultSet.next()) {
            String first_nameName = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            Date date = resultSet.getDate("date");
            System.out.println(first_nameName + " " + last_name + " " + gender + " " + address + " " + date);

        }


        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }


    }
}

