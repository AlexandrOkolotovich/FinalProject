package by.jwd.restaurant.dao;

import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.exception.DAOException;

public interface UserDAO {
    User authorization(User user) throws DAOException;
    boolean registration(User user) throws DAOException;
}
