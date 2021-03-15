package by.jwd.restaurant.service;

import by.jwd.restaurant.bean.RegistrationInfo;
import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.exception.ServiceException;

public interface UserService {
    User authorization(String login, String password) throws ServiceException;
    boolean registration(RegistrationInfo user) throws ServiceException;
}
