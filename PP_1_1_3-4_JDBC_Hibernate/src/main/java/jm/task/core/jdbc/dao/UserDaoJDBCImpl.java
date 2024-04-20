package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }
    Util connect = new Util();
    Connection connection = connect.getConnection();



    public void createUsersTable() throws SQLException {
        try {
            String sqlCreateUT = "CREATE TABLE IF NOT EXISTS users2 (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20)," +
                    " lastName VARCHAR(20), age TINYINT)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCreateUT);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            if (connection != null) {
                connection.close();
            }
        }*/

    }

    public void dropUsersTable() throws SQLException {
        try {
            String sqlDropUT = "DROP TABLE IF EXISTS users2";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDropUT);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } /*finally {
            if (connection != null) {
                connection.close();
            }
        }*/

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sqlSaveU = "insert into users2 (name, lastName, age) values (?, ?, ?)";
        try {
//            preparedStatement = connection.prepareStatement(sqlSaveU);
            preparedStatement = connect.getConnection().prepareStatement(sqlSaveU);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User с именем- " + name + " добавлен в базу данных.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } /*finally {
            if (connection != null) {
                connection.close();
            }
        }*/

    }

    public void removeUserById(long id) {

        try {
            String sqlRemoveU = "DELETE FROM users2 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRemoveU);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM users2";
        Statement statement1 = null;
        try {
            statement1 = connect.getConnection().createStatement();
            ResultSet resultSet = statement1.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
        return list;
    }

    public void cleanUsersTable() {
        try {
            String sqlCleanUT = "TRUNCATE TABLE users2";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCleanUT);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
