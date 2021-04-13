package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.entity.OrderStatus;

import java.sql.*;
import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    private static final String CREATE_ORDER = "INSERT INTO orders (order_status, order_time, order_total_price, order_review, user_id) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_ORDER_DISH = "INSERT INTO odereddishes (dish_id, order_id) VALUES (?, ?)";
    private static final String CREATE_ORDER_DRINK = "INSERT INTO ordereddrinks (drink_id, order_id) VALUES (?, ?)";
    private static final String DELETE_ORDERED_DISH = "DELETE FROM odereddishes WHERE odered_dishes_id = ?";
    private static final String CREATE_NEW_ORDER = "INSERT INTO orders (order_status, user_id) VALUES (?, ?)";
    private static final String GET_ORDER_ID = "SELECT order_id FROM orders WHERE order_status = ? AND user_id = ?";
    private static final String UPDATE_ORDER_STATUS = "UPDATE orders SET order_status = ? WHERE order_status = ?";

    private static final String COLUMN_LABEL_ORDER_ID = "order_id";

    @Override
    public List<Order> getAll() throws DAOException {
        return null;
    }

    @Override
    public Order createOrder(Order order) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_ORDER);
            prSt.setString(1, order.getStatus().name());
            prSt.setDate(2, (Date) order.getTime());
            prSt.setDouble(3, order.getTotalPrice());
            prSt.setString(4, order.getReview());
            prSt.setInt(5, order.getUserId());

            prSt.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return order;
    }

    @Override
    public void createOrderDish(Integer dishId, Integer orderId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_ORDER_DISH);
            prSt.setInt(1, dishId);
            prSt.setInt(2, orderId);

            prSt.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
    }

    @Override
    public Order createOrderDrink(Order order) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_ORDER_DRINK);
            prSt.setInt(1, order.getDrink().getId());
            prSt.setInt(2, order.getId());

            prSt.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
        return order;
    }

    @Override
    public void deleteOrderedDish(Integer orderedDishId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try{
            connection = connectionPool.takeConnection();

            prSt = connection.prepareStatement(DELETE_ORDERED_DISH);
            prSt.setInt(1, orderedDishId);

            prSt.executeUpdate();
        } catch(SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void makeNewOrder(Integer userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_NEW_ORDER);
            prSt.setString(1, OrderStatus.PREPARING.name());
            prSt.setInt(2, userId);

            prSt.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
    }

    @Override
    public Integer getOrderId(Integer userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        Integer id = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ORDER_ID);
            prSt.setString(1, OrderStatus.PREPARING.name());
            prSt.setInt(2, userId);

            resSet = prSt.executeQuery();

            if(resSet.next()) {
                id = resSet.getInt(COLUMN_LABEL_ORDER_ID);
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }

        return id;
    }

    @Override
    public void updateOrderStatus() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(UPDATE_ORDER_STATUS);
            prSt.setString(1, OrderStatus.VIOLATED.name());
            prSt.setString(2, OrderStatus.PREPARING.name());

            prSt.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, prSt);
            }catch (ConnectionPoolException e){
                throw new DAOException(e);
            }
        }
    }
}
