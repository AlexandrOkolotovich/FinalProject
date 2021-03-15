package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.bean.RegistrationInfo;
import by.jwd.restaurant.dao.UserDAO;
import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.exception.DAOException;

import java.sql.*;

public class SQLUserDAO implements UserDAO {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/restaurant?useSSL=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "123123";

    private static final String SELECT_USER_EMAIL_PASSWORD = "SELECT * FROM users WHERE user_email = ? AND user_password = ?";
    private static final String SELECT_USER_ID = "SELECT user_id FROM users WHERE user_email = ? ";
    private static final String INSERT_REGISTRATION_USER = "INSERT INTO users (user_name, user_surname, user_phone, user_email, user_password, role_id) VALUES (?, ?, ?, ?, ?, ?)";


    static {
        MySQLDriverLoader.getInstance();
    }

    @Override
    public User authorization(String login, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement prSt;
        ResultSet resSet;

        Integer id;
        String user_password;
        User user = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
            prSt = connection.prepareStatement(SELECT_USER_EMAIL_PASSWORD);
            prSt.setString(1, login);
            prSt.setString(2, password);
            resSet = prSt.executeQuery();

            if(resSet.next()){
                id = resSet.getInt("user_id");
                user_password = resSet.getString("user_password");

                if(!password.equals(user_password)){
                    return null;
                }

                user = new User(id, login, password);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.err.println("Close connection exception");
            }
        }
        return user;
    }

    @Override
    public boolean registration(RegistrationInfo user) throws DAOException {
        Connection connection = null;
        PreparedStatement prSt;

        final int role = 2; // user id = 2

        try {
            connection = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
            prSt = connection.prepareStatement(INSERT_REGISTRATION_USER);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getSurname());
            prSt.setString(3, user.getPhone());
            prSt.setString(4, user.getEmail());
            prSt.setString(5, user.getPassword());
            prSt.setInt(6, role);
            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Close connection exception");
            }
        }

        return true;
    }

    @Override
    public Integer findId(String email) throws DAOException {

        Connection connection = null;
        PreparedStatement prSt;
        ResultSet resSet;

        Integer id = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
            prSt = connection.prepareStatement(SELECT_USER_ID);
            prSt.setString(1, email);

            resSet = prSt.executeQuery();

            if(resSet.next()){
                id = resSet.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.err.println("Close connection exception");
            }
        }
        return id;
    }
}
