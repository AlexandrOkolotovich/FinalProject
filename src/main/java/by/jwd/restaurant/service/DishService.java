package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public interface DishService {
    List<Dish> getDishes() throws ServiceException;
    boolean addNewDish(Dish dish) throws ServiceException;
    void makeNotAvailable(Integer id) throws ServiceException;
    Dish getDish(Integer id) throws ServiceException;
    void updateDish(Dish dish) throws ServiceException;
    List<Dish> getOrderedDishes(Integer id) throws ServiceException;
    List<Dish> searchDishByTitle(String title) throws ServiceException;
    List<Dish> sortDishByTitle() throws ServiceException;
    List<Dish> sortDishByPriceUp() throws ServiceException;
    List<Dish> sortDishByPriceDown() throws ServiceException;
}
