package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.Drink;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public interface DrinkService {
    List<Drink> getDrinks() throws ServiceException;
    boolean addNewDrink(Drink drink) throws ServiceException;
    void makeNotAvailable(Integer id) throws ServiceException;
    Drink getDrink(Integer id) throws ServiceException;
    void updateDrink(Drink drink) throws ServiceException;
    List<Drink> getOrderedDrinks(Integer id) throws ServiceException;
}
