package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.DishDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDishDAOTest {
    private static final String NEW_TITLE = "Название";
    private static final String NEW_DESCRIPTION = "Описание";
    private static final Double NEW_PRICE = 10.0;
    private static final Float NEW_CALORIE_CONTENT = 7.25f;
    private static final Boolean NEW_IS_AVAILABLE = true;
    private static final String NEW_PICTURE_PATH = "/static/img/dinner-01.jpg";
    private static final String SELECT_NEW_DISH_SQL = "SELECT * FROM dishes WHERE dish_title='Название'";


    private static final DishDAO dishDAO = DAOProvider.getInstance().getDishDAO();

    @BeforeClass
    public static void connectionPoolInit() throws ConnectionPoolException {
        ConnectionPool.getInstance().initPoolData();
    }

    @AfterClass
    public static void connectionPoolDestroy() throws ConnectionPoolException {
        ConnectionPool.getInstance().dispose();
    }

    @Test
    public void createTest() throws DAOException, SQLException, ConnectionPoolException {
        Dish dish = new Dish(NEW_TITLE, NEW_DESCRIPTION, NEW_PRICE, NEW_CALORIE_CONTENT, NEW_IS_AVAILABLE, NEW_PICTURE_PATH);
        dishDAO.setNewDish(dish);

        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             Statement statement = connection.createStatement()) {
             ResultSet resultSet = statement.executeQuery(SELECT_NEW_DISH_SQL);
             Assert.assertTrue(resultSet.next());
        }
    }
}
