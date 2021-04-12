package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll() throws DAOException;
    Order createOrder(Order order) throws DAOException;
    void createOrderDish(Integer dishId, Integer orderId) throws DAOException;
    Order createOrderDrink(Order order) throws DAOException;
    void deleteOrderedDish(Integer orderedDishId) throws DAOException;
}
