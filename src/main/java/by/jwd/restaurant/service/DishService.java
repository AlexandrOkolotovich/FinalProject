package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public interface DishService {
    List<Dish> getDishes() throws ServiceException;
    boolean addNewDish(Dish dish) throws ServiceException;
}
