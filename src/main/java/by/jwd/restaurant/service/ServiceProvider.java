package by.jwd.restaurant.service;

import by.jwd.restaurant.service.impl.*;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {}

    private final UserService userService = new UserServiceImpl();

    private final DishService dishService = new DishServiceImpl();

    private final OrderService orderService = new OrderServiceImpl();

    private final EmailService emailService = new EmailServiceImpl();

    private final DrinkService drinkService = new DrinkServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public DishService getDishService(){
        return dishService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public DrinkService getDrinkService() {
        return drinkService;
    }
}
