package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
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
    public void deleteDishInOrder(Integer dishId, Integer orderId) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.deleteOrderedDish(dishId, orderId);
        } catch (DAOException e){
            throw new ServiceException("delete ordered dish exception", e);
        }
    }

    @Override
    public void makeNewOrder(Integer userId) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try{
            orderDAO.makeNewOrder(userId);
        } catch (DAOException e){
            throw new ServiceException("make new order exception", e);
        }
    }

    @Override
    public Integer getOrderId(Integer userId) throws ServiceException {
        Integer id;

        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try {
            id = orderDAO.getOrderId(userId);
        } catch (DAOException e) {
            throw new ServiceException("get order id exception", e);
        }

        return id;
    }

    @Override
    public void checkOrderStatus() throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        try {
            orderDAO.updateOrderStatus();
        } catch (DAOException e) {
            throw new ServiceException("update order status exception", e);
        }
    }

    @Override
    public Double getTotalPrice(List<Dish> dishList) throws ServiceException {
        double totalPrice = 0;

        for(Dish dish : dishList){
            totalPrice+=dish.getPrice();
        }

        return totalPrice;
    }

    @Override
    public List<Order> getUserOrders(Integer userId) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        OrderDAO orderDAO = provider.getOrderDAO();

        List<Order> orders = null;
        try {
            orders = orderDAO.getUserOrders(userId);
        } catch (DAOException e) {
            throw new ServiceException("get user orders exception", e);
        }

        return orders;
    }

}
