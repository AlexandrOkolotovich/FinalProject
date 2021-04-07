package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    private static final String CREATE_ORDER = "INSERT INTO orders (order_status, order_time, order_total_price, order_review, user_id) VALUES (?, ?, ?, ?, ?)";
    private static final String CREATE_ORDER_DISH = "INSERT INTO odereddishes (dish_id, order_id) VALUES (?, ?)";
    private static final String CREATE_ORDER_DRINK = "INSERT INTO ordereddrinks (drink_id, order_id) VALUES (?, ?)";

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
    public Order createOrderDish(Order order) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_ORDER_DISH);
            prSt.setInt(1, order.getDish().getId());
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
}
