package by.jwd.restaurant.service;

import by.jwd.restaurant.service.impl.DishServiceImpl;
import by.jwd.restaurant.service.impl.UserServiceImpl;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {}

    private final UserService userService = new UserServiceImpl();

    private final DishService dishService = new DishServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public DishService getDishService(){
        return dishService;
    }

}
