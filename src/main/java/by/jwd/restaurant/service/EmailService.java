package by.jwd.restaurant.service;

import by.jwd.restaurant.service.exception.ServiceException;

public interface EmailService {
    void mail(String mail, String password) throws ServiceException;
}

