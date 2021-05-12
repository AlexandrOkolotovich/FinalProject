package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.DishDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.RegistrationInfo;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.exception.ServiceException;
import by.jwd.restaurant.service.validation.DishValidator;
import by.jwd.restaurant.service.validation.UserValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        if(dish == null || !validateAddDish(dish)){
            throw new ServiceException("wrong add dish");
        }

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishDAO.setNewDish(dish);
        } catch (DAOException e) {
            throw new ServiceException("add new dish exception", e);
        }

        return true;
    }

    public boolean validateAddDish(Dish dish) throws ServiceException {
        if(!DishValidator.validateTitle(dish.getTitle())){
            throw new ServiceException("wrong title");
        }
        if(!DishValidator.validateDescription(dish.getDescription())){
            throw new ServiceException("wrong description");
        }
        if(!DishValidator.validatePrice(dish.getPrice())){
            throw new ServiceException("wrong price");
        }
        if(!DishValidator.validateCalorieContent(dish.getCalorieContent())){
            throw new ServiceException("wrong calorie content");
        }
        if(!DishValidator.validatePicturePath(dish.getPicturePath())){
            throw new ServiceException("wrong password");
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

    @Override
    public List<Dish> getOrderedDishes(Integer orderId) throws ServiceException {
        List<Dish> orderedDishes = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            orderedDishes = dishDAO.getOrderedDishes(orderId);
        } catch (DAOException e) {
            throw new ServiceException("get dishes exception", e);
        }

        return orderedDishes;
    }

    @Override
    public List<Dish> searchDishByTitle(String title) throws ServiceException {
        List<Dish> allDishes = null;
        List<Dish> result = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            allDishes = dishDAO.getAll();
            result = allDishes.stream().filter(item -> item.getTitle().equals(title))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException("search dishes exception", e);
        }

        return result;
    }

    @Override
    public List<Dish> sortDishByTitle() throws ServiceException {
        List<Dish> dishes = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishes = dishDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get dishes exception", e);
        }

        Comparator<Dish> comp = new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };

        dishes.sort(comp);

        return dishes;
    }

    @Override
    public List<Dish> sortDishByPriceUp() throws ServiceException {
        List<Dish> dishes = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishes = dishDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get dishes exception", e);
        }

        Comparator<Dish> comp = new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };

        dishes.sort(comp);

        return dishes;
    }

    @Override
    public List<Dish> sortDishByPriceDown() throws ServiceException {
        List<Dish> dishes = null;

        DAOProvider provider = DAOProvider.getInstance();
        DishDAO dishDAO = provider.getDishDAO();

        try {
            dishes = dishDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get dishes exception", e);
        }

        Comparator<Dish> comp = new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        };

        dishes.sort(comp);

        return dishes;
    }

}
