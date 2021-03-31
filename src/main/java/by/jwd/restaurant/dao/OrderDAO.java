package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll() throws DAOException;
}
