package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.OrderDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.entity.OrderStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    private static final String CREATE_ORDER = "UPDATE orders SET order_status = ?, order_time = ?, order_total_price = ? WHERE order_id = ?";
    private static final String CREATE_ORDER_DISH = "INSERT INTO odereddishes (dish_id, order_id) VALUES (?, ?)";
    private static final String CREATE_ORDER_DRINK = "INSERT INTO ordereddrinks (drink_id, order_id) VALUES (?, ?)";
    private static final String DELETE_ORDERED_DISH = "DELETE FROM odereddishes WHERE dish_id = ? AND order_id = ?";
    private static final String CREATE_NEW_ORDER = "INSERT INTO orders (order_status, user_id) VALUES (?, ?)";
    private static final String GET_ORDER_ID = "SELECT order_id FROM orders WHERE order_status = ? AND user_id = ?";
    private static final String UPDATE_ORDER_STATUS = "UPDATE orders SET order_status = ? WHERE order_status = ?";
    private static final String GET_USER_ORDERS = "SELECT * FROM orders WHERE user_id = ?";
    private static final String GET_ORDERS = "SELECT * FROM orders";
    private static final String GET_ORDERED_DISHES = "SELECT dishes.dish_title, dishes.dish_price, odereddishes.dish_id FROM dishes JOIN odereddishes ON dishes.dish_id=odereddishes.dish_id WHERE odereddishes.order_id=?";

    private static final String COLUMN_LABEL_ORDER_ID = "order_id";
    private static final String COLUMN_LABEL_ORDER_STATUS = "order_status";
    private static final String COLUMN_LABEL_ORDER_TIME = "order_time";
    private static final String COLUMN_LABEL_ORDER_TOTAL_PRICE = "order_total_price";
    private static final String COLUMN_LABEL_ORDER_REVIEW = "order_review";
    private static final String COLUMN_LABEL_ORDER_USER_ID = "user_id";
    private static final String COLUMN_LABEL_ORDER_PAYMENT_METHOD_ID = "order_payment_method_id";
    private static final String COLUMN_LABEL_ORDER_TABLE_RESERVATION_ID = "table_reservation_id";
    private static final String COLUMN_LABEL_DISH_TITLE = "dish_title";
    private static final String COLUMN_LABEL_DISH_PRICE = "dish_price";

    @Override
    public Order createOrder(Order order) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        java.util.Date utilDate = order.getTime();
        java.sql.Timestamp date = new Timestamp(utilDate.getTime());

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(CREATE_ORDER);
            prSt.setString(1, OrderStatus.PAID.name());
            prSt.setTimestamp(2, date);
            prSt.setDouble(3, order.getTotalPrice());
            prSt.setInt(4, order.getId());

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
    public void deleteOrderedDish(Integer dishId, Integer orderId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try{
            connection = connectionPool.takeConnection();

            prSt = connection.prepareStatement(DELETE_ORDERED_DISH);
            prSt.setInt(1, dishId);
            prSt.setInt(2, orderId);

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

    @Override
    public List<Order> getUserOrders(Integer userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Order> orders = new ArrayList<>();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_USER_ORDERS);
            prSt.setInt(1, userId);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Order order = new Order();
                order.setId(resSet.getInt(COLUMN_LABEL_ORDER_ID));
                order.setStatus(OrderStatus.valueOf(resSet.getString(COLUMN_LABEL_ORDER_STATUS)));
                order.setTime(resSet.getTimestamp(COLUMN_LABEL_ORDER_TIME));
                order.setTotalPrice(resSet.getDouble(COLUMN_LABEL_ORDER_TOTAL_PRICE));
                order.setReview(resSet.getString(COLUMN_LABEL_ORDER_REVIEW));
                order.setUserId(resSet.getInt(COLUMN_LABEL_ORDER_USER_ID));
                order.setOrderPaymentMethodId(resSet.getInt(COLUMN_LABEL_ORDER_PAYMENT_METHOD_ID));
                order.setTableReservationId(resSet.getInt(COLUMN_LABEL_ORDER_TABLE_RESERVATION_ID));

                order.setDishes(getOrderedDishes(order.getId()));

                orders.add(order);
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

        return orders;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Order> orders = new ArrayList<>();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ORDERS);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Order order = new Order();
                order.setId(resSet.getInt(COLUMN_LABEL_ORDER_ID));
                order.setStatus(OrderStatus.valueOf(resSet.getString(COLUMN_LABEL_ORDER_STATUS)));
                order.setTime(resSet.getTimestamp(COLUMN_LABEL_ORDER_TIME));
                order.setTotalPrice(resSet.getDouble(COLUMN_LABEL_ORDER_TOTAL_PRICE));
                order.setReview(resSet.getString(COLUMN_LABEL_ORDER_REVIEW));
                order.setUserId(resSet.getInt(COLUMN_LABEL_ORDER_USER_ID));
                order.setOrderPaymentMethodId(resSet.getInt(COLUMN_LABEL_ORDER_PAYMENT_METHOD_ID));
                order.setTableReservationId(resSet.getInt(COLUMN_LABEL_ORDER_TABLE_RESERVATION_ID));

                order.setDishes(getOrderedDishes(order.getId()));

                orders.add(order);
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

        return orders;
    }

    public List<Dish> getOrderedDishes(Integer orderId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Dish> dishList = new ArrayList<>();


        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ORDERED_DISHES);
            prSt.setInt(1, orderId);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Dish dish = new Dish();

                dish.setTitle(resSet.getString(COLUMN_LABEL_DISH_TITLE));
                dish.setPrice(resSet.getDouble(COLUMN_LABEL_DISH_PRICE));

                dishList.add(dish);
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

        return dishList;
    }
}
