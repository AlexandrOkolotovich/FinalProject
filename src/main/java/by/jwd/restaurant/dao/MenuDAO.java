package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Menu;

import java.util.List;

public interface MenuDAO {
    List<Menu> getAll() throws DAOException;
}
