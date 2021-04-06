package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.DishDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public class DishServiceImpl implements DishService {
    @Override
    public List<Dish> getDishes() throws ServiceException {
        List<Dish> allDishes = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            allDishes = dishDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get dishes exception", e);
        }

        return allDishes;
    }

    @Override
    public boolean addNewDish(Dish dish) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishDAO.setNewDish(dish);
        } catch (DAOException e) {
            throw new ServiceException("add new dish exception", e);
        }

        return true;
    }

}
