package by.jwd.restaurant.dao;

import by.jwd.restaurant.bean.RegistrationInfo;
import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.dao.exception.DAOException;

public interface UserDAO {
    User authorization(String login, String password) throws DAOException;
    boolean registration(RegistrationInfo user) throws DAOException;
    Integer findId(String email) throws DAOException;
}
