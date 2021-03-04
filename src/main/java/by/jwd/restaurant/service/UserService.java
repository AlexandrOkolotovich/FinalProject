package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.User;

public interface UserService {
    User authorization(User user);
    boolean registration(User user);
}
