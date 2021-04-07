package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DrinkDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
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
    private static final String COLUMN_LABEL_DRINK_IS_AVAILABLE = "drink_is_available";
    private static final String COLUMN_LABEL_DRINK_PICTURE_PATH = "drink_picture_path";

    private static final String GET_ALL = "SELECT * FROM drinks";
    private static final String INSERT_NEW_DRINK = "INSERT INTO drinks (drink_title, drink_description, drink_price, drink_is_avaible, drink_picture_path) VALUES (?, ?, ?, ?, ?)";

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
}
