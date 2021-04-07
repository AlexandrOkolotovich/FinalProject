package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    boolean makeOrder(Order order) throws ServiceException;
    List<Order> getAllOrders() throws ServiceException;
}
