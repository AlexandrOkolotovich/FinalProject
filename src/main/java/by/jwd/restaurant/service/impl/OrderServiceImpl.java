package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public boolean makeOrder(Order order) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try {
            orderDAO.createOrder(order);
        } catch (DAOException e) {
            throw new ServiceException("make order exception", e);
        }
        return true;
    }

    @Override
    public List<Order> getAllOrders() throws ServiceException {
        List<Order> allOrders = null;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try {
            allOrders = orderDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get all orders exception", e);
        }

        return allOrders;
    }

    @Override
    public boolean addDishToOrder(Integer dishId, Integer orderId) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try {
            orderDAO.createOrderDish(dishId, orderId);
        } catch (DAOException e) {
            throw new ServiceException("make order exception", e);
        }

        return true;
    }

    @Override
    public void deleteDishInOrder(Integer orderedDishId) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.deleteOrderedDish(orderedDishId);
        } catch (DAOException e){
            throw new ServiceException("delete ordered dish exception", e);
        }
    }
}
