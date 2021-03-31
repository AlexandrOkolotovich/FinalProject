package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Order;

import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    @Override
    public List<Order> getAll() throws DAOException {
        return null;
    }
}
