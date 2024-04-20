package jm.task.core.jdbc.util;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;

import java.sql.*;

public class Util {
    public Util() {

    }

    private final String URL ="jdbc:mysql://localhost:3306/pp_ex.1.1.2";
    private final String USERNAME = "root";
    private final String PASSWORD = "double";
    private Connection connection;
    {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(true);
            if (!connection.isClosed()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    // реализуйте настройку соеденения с БД
}
