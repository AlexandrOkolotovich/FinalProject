package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DishDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLDishDAO implements DishDAO {
    private static final String COLUMN_LABEL_DISH_ID = "dish_id";
    private static final String COLUMN_LABEL_DISH_TITLE = "dish_title";
    private static final String COLUMN_LABEL_DISH_DESCRIPTION = "dish_description";
    private static final String COLUMN_LABEL_DISH_PRICE = "dish_price";
    private static final String COLUMN_LABEL_DISH_CALORIE_CONTENT = "dish_calorie_content";
    private static final String COLUMN_LABEL_DISH_IS_AVAILABLE = "dish_is_available";
    private static final String COLUMN_LABEL_DISH_PICTURE_PATH = "dish_picture_path";

    private static final int IS_AVAILABLE_FALSE = 0;

    private static final String GET_ALL = "SELECT * FROM dishes";
    private static final String INSERT_NEW_DISH = "INSERT INTO dishes (dish_title, dish_description, dish_price, dish_calorie_content, dish_is_available, dish_picture_path) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_DISH = "SELECT * FROM dishes WHERE dish_id = ?";
    private static final String UPDATE_AVAILABLE_DISH = "UPDATE dishes SET dish_is_available = ? WHERE dish_id = ?";
    private static final String UPDATE_DISH = "UPDATE dishes SET dish_title = ?, dish_description = ?, dish_price = ?, dish_calorie_content = ?, dish_is_available = ?, dish_picture_path = ? WHERE dish_id = ?";
    private static final String GET_ORDERED_DISHES = "SELECT * FROM dishes JOIN odereddishes ON dishes.dish_id=odereddishes.dish_id WHERE odereddishes.order_id = ?";

    static {
        MySQLDriverLoader.getInstance();
    }

    @Override
    public List<Dish> getAll() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Dish> dishList = new ArrayList<>();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ALL);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Dish dish = new Dish();
                dish.setId(resSet.getInt(COLUMN_LABEL_DISH_ID));
                dish.setTitle(resSet.getString(COLUMN_LABEL_DISH_TITLE));
                dish.setDescription(resSet.getString(COLUMN_LABEL_DISH_DESCRIPTION));
                dish.setPrice(resSet.getDouble(COLUMN_LABEL_DISH_PRICE));
                dish.setCalorieContent(resSet.getFloat(COLUMN_LABEL_DISH_CALORIE_CONTENT));
                dish.setAvailable(resSet.getBoolean(COLUMN_LABEL_DISH_IS_AVAILABLE));
                dish.setPicturePath(resSet.getString(COLUMN_LABEL_DISH_PICTURE_PATH));
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

    @Override
    public boolean setNewDish(Dish dish) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(INSERT_NEW_DISH);
            prSt.setString(1, dish.getTitle());
            prSt.setString(2, dish.getDescription());
            prSt.setDouble(3, dish.getPrice());
            prSt.setFloat(4, dish.getCalorieContent());
            prSt.setBoolean(5, dish.isAvailable());
            prSt.setString(6, dish.getPicturePath());

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

        return true;
    }

    @Override
    public Dish getDish(Integer id) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        Dish dish = new Dish();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_DISH);
            prSt.setInt(1, id);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                dish.setId(resSet.getInt(COLUMN_LABEL_DISH_ID));
                dish.setTitle(resSet.getString(COLUMN_LABEL_DISH_TITLE));
                dish.setDescription(resSet.getString(COLUMN_LABEL_DISH_DESCRIPTION));
                dish.setPrice(resSet.getDouble(COLUMN_LABEL_DISH_PRICE));
                dish.setCalorieContent(resSet.getFloat(COLUMN_LABEL_DISH_CALORIE_CONTENT));
                dish.setAvailable(resSet.getBoolean(COLUMN_LABEL_DISH_IS_AVAILABLE));
                dish.setPicturePath(resSet.getString(COLUMN_LABEL_DISH_PICTURE_PATH));
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

        return dish;
    }

    @Override
    public void updateDishNotAvailable(Integer id) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(UPDATE_AVAILABLE_DISH);
            prSt.setInt(1, IS_AVAILABLE_FALSE);
            prSt.setInt(2, id);

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
    public void updateDish(Dish dish) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(UPDATE_DISH);
            prSt.setString(1, dish.getTitle());
            prSt.setString(2, dish.getDescription());
            prSt.setDouble(3, dish.getPrice());
            prSt.setFloat(4, dish.getCalorieContent());
            prSt.setBoolean(5, dish.isAvailable());
            prSt.setString(6, dish.getPicturePath());
            prSt.setInt(7, dish.getId());

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
                dish.setId(resSet.getInt(COLUMN_LABEL_DISH_ID));
                dish.setTitle(resSet.getString(COLUMN_LABEL_DISH_TITLE));
                dish.setDescription(resSet.getString(COLUMN_LABEL_DISH_DESCRIPTION));
                dish.setPrice(resSet.getDouble(COLUMN_LABEL_DISH_PRICE));
                dish.setCalorieContent(resSet.getFloat(COLUMN_LABEL_DISH_CALORIE_CONTENT));
                dish.setAvailable(resSet.getBoolean(COLUMN_LABEL_DISH_IS_AVAILABLE));
                dish.setPicturePath(resSet.getString(COLUMN_LABEL_DISH_PICTURE_PATH));
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
