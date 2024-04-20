package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.dropUsersTable();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Tantyana", "Fedorova", (byte) 25);
        userDaoJDBC.saveUser("Tantyana", "Fedorova", (byte) 25);
        userDaoJDBC.saveUser("Olga", "Petrova",(byte) 34);
        userDaoJDBC.saveUser("Igor", "Serov", (byte) 26);
        userDaoJDBC.saveUser("Nikolay", "Egorov", (byte) 23);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.removeUserById(2);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();

        // реализуйте алгоритм здесь
    }
}

