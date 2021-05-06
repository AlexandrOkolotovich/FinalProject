package by.jwd.restaurant.service;

import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    boolean makeOrder(Order order) throws ServiceException;
    List<Order> getAllOrders() throws ServiceException;
    boolean addDishToOrder(Integer dishId, Integer orderId) throws ServiceException;
    void deleteDishInOrder(Integer dishId, Integer orderId) throws ServiceException;
    void makeNewOrder(Integer userId) throws ServiceException;
    Integer getOrderId(Integer userId) throws ServiceException;
    void checkOrderStatus() throws ServiceException;
    Double getTotalPrice(List<Dish> dishList) throws ServiceException;
    List<Order> getUserOrders(Integer userId) throws ServiceException;
}
