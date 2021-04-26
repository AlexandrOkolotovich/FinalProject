package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DrinkDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Drink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLDrinkDAO implements DrinkDAO {
    private static final String COLUMN_LABEL_DRINK_ID = "drink_id";
    private static final String COLUMN_LABEL_DRINK_TITLE = "drink_title";
    private static final String COLUMN_LABEL_DRINK_DESCRIPTION = "drink_description";
    private static final String COLUMN_LABEL_DRINK_PRICE = "drink_price";
    private static final String COLUMN_LABEL_DRINK_IS_AVAILABLE = "drink_is_avaible";
    private static final String COLUMN_LABEL_DRINK_PICTURE_PATH = "drink_picture_path";

    private static final int IS_AVAILABLE_FALSE = 0;

    private static final String GET_ALL = "SELECT * FROM drinks";
    private static final String INSERT_NEW_DRINK = "INSERT INTO drinks (drink_title, drink_description, drink_price, drink_is_avaible, drink_picture_path) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_DRINK = "SELECT * FROM drinks WHERE drink_id = ?";
    private static final String UPDATE_AVAILABLE_DRINK = "UPDATE drinks SET drink_is_avaible = ? WHERE drink_id = ?";
    private static final String UPDATE_DRINK = "UPDATE drinks SET drink_title = ?, drink_description = ?, drink_price = ?, drink_is_avaible = ?, drink_picture_path = ? WHERE drink_id = ?";
    private static final String GET_ORDERED_DRINKS = "SELECT * FROM drinks JOIN ordereddrinks ON drinks.drink_id=ordereddrinks.drink_id WHERE ordereddrinks.order_id = ?";

    static {
        MySQLDriverLoader.getInstance();
    }

    @Override
    public List<Drink> getAll() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Drink> drinkList = new ArrayList<>();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ALL);


            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Drink drink = new Drink();
                drink.setId(resSet.getInt(COLUMN_LABEL_DRINK_ID));
                drink.setTitle(resSet.getString(COLUMN_LABEL_DRINK_TITLE));
                drink.setDescription(resSet.getString(COLUMN_LABEL_DRINK_DESCRIPTION));
                drink.setPrice(resSet.getDouble(COLUMN_LABEL_DRINK_PRICE));
                drink.setAvailable(resSet.getBoolean(COLUMN_LABEL_DRINK_IS_AVAILABLE));
                drink.setPicturePath(resSet.getString(COLUMN_LABEL_DRINK_PICTURE_PATH));
                drinkList.add(drink);
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
        return drinkList;
    }

    @Override
    public boolean setNewDrink(Drink drink) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(INSERT_NEW_DRINK);
            prSt.setString(1, drink.getTitle());
            prSt.setString(2, drink.getDescription());
            prSt.setDouble(3, drink.getPrice());
            prSt.setBoolean(4, drink.isAvailable());
            prSt.setString(5, drink.getPicturePath());

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
    public Drink getDrink(Integer id) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        Drink drink = new Drink();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_DRINK);
            prSt.setInt(1, id);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                drink.setId(resSet.getInt(COLUMN_LABEL_DRINK_ID));
                drink.setTitle(resSet.getString(COLUMN_LABEL_DRINK_TITLE));
                drink.setDescription(resSet.getString(COLUMN_LABEL_DRINK_DESCRIPTION));
                drink.setPrice(resSet.getDouble(COLUMN_LABEL_DRINK_PRICE));
                drink.setAvailable(resSet.getBoolean(COLUMN_LABEL_DRINK_IS_AVAILABLE));
                drink.setPicturePath(resSet.getString(COLUMN_LABEL_DRINK_PICTURE_PATH));
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

        return drink;
    }

    @Override
    public void updateDrinkNotAvailable(Integer id) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(UPDATE_AVAILABLE_DRINK);
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
    public void updateDrink(Drink drink) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(UPDATE_DRINK);
            prSt.setString(1, drink.getTitle());
            prSt.setString(2, drink.getDescription());
            prSt.setDouble(3, drink.getPrice());
            prSt.setBoolean(4, drink.isAvailable());
            prSt.setString(5, drink.getPicturePath());
            prSt.setInt(6, drink.getId());

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
    public List<Drink> getOrderedDrinks(Integer orderId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement prSt = null;
        ResultSet resSet;

        List<Drink> drinkList = new ArrayList<>();

        try {
            connection = connectionPool.takeConnection();
            prSt = connection.prepareStatement(GET_ORDERED_DRINKS);

            prSt.setInt(1, orderId);

            resSet = prSt.executeQuery();
            while (resSet.next()) {
                Drink drink = new Drink();
                drink.setId(resSet.getInt(COLUMN_LABEL_DRINK_ID));
                drink.setTitle(resSet.getString(COLUMN_LABEL_DRINK_TITLE));
                drink.setDescription(resSet.getString(COLUMN_LABEL_DRINK_DESCRIPTION));
                drink.setPrice(resSet.getDouble(COLUMN_LABEL_DRINK_PRICE));

                drink.setAvailable(resSet.getBoolean(COLUMN_LABEL_DRINK_IS_AVAILABLE));
                drink.setPicturePath(resSet.getString(COLUMN_LABEL_DRINK_PICTURE_PATH));
                drinkList.add(drink);
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
        return drinkList;
    }
}
