package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAll() throws DAOException;
    boolean setNewDish(Dish dish) throws DAOException;
}
