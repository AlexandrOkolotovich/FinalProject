package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.impl.SQLDishDAO;
import by.jwd.restaurant.dao.impl.SQLDrinkDAO;
import by.jwd.restaurant.dao.impl.SQLOrderDAO;
import by.jwd.restaurant.dao.impl.SQLUserDAO;

public final class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();

    private final DishDAO dishDAO = new SQLDishDAO();

    private final DrinkDAO drinkDAO = new SQLDrinkDAO();

    private final OrderDAO orderDAO = new SQLOrderDAO();

    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public DishDAO getDishDAO(){
        return dishDAO;
    }

    public DrinkDAO getDrinkDAO() {
        return drinkDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
