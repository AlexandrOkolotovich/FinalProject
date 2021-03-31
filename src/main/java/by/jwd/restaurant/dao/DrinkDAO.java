package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Drink;

import java.util.List;

public interface DrinkDAO {
    List<Drink> getAll() throws DAOException;
}
