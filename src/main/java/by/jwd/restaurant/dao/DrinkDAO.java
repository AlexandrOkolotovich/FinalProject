package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Drink;

import java.util.List;

public interface DrinkDAO {
    List<Drink> getAll() throws DAOException;
    boolean setNewDrink(Drink drink) throws DAOException;
    Drink getDrink(Integer id) throws DAOException;
    void updateDrinkNotAvailable(Integer id) throws DAOException;
    void updateDrink(Drink drink) throws DAOException;
    List<Drink> getOrderedDrinks(Integer id) throws DAOException;
}