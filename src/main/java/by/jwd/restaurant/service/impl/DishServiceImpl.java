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

    @Override
    public void makeNotAvailable(Integer id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishDAO.updateDishNotAvailable(id);
        } catch (DAOException e) {
            throw new ServiceException("update dish not available exception", e);
        }
    }

    @Override
    public Dish getDish(Integer id) throws ServiceException {
        Dish dish;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dish = dishDAO.getDish(id);
        } catch (DAOException e) {
            throw new ServiceException("get dish exception", e);
        }

        return dish;
    }

    @Override
    public void updateDish(Dish dish) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishDAO.updateDish(dish);
        } catch (DAOException e) {
            throw new ServiceException("update dish not available exception", e);
        }
    }

}
