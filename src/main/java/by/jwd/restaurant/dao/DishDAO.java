package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAll() throws DAOException;
    boolean setNewDish(Dish dish) throws DAOException;
    Dish getDish(Integer id) throws DAOException;
    void updateDishNotAvailable(Integer id) throws DAOException;
    void updateDish(Dish dish) throws DAOException;
    List<Dish> getOrderedDishes(Integer id) throws DAOException;
}
