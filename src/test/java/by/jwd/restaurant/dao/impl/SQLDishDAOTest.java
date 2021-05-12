package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.DishDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;

import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Dish;
import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDishDAOTest {
    private static final String NEW_TITLE = "Новое";
    private static final String NEW_DESCRIPTION = "Новое";
    private static final Double NEW_PRICE = 12.40;
    private static final Float NEW_CALORIE_CONTENT = 13.25f;
    private static final Boolean NEW_IS_AVAILABLE = true;
    private static final String NEW_PICTURE_PATH = "/static/img/blog-15.jpg";

    private static final String TITLE = "Название";
    private static final String DESCRIPTION = "Описание";
    private static final double PRICE = 10.00;
    private static final float CALORIE_CONTENT = 7.25f;
    private static final boolean IS_AVAILABLE = true;
    private static final String PICTURE_PATH = "/static/img/dinner-01.jpg";
    private static final Integer DISH_ID = 11;

    private static final String SELECT_NEW_DISH_SQL = "SELECT * FROM dishes WHERE dish_title='Новое'";

    private static final DishDAO dishDAO = DAOProvider.getInstance().getDishDAO();



    private Dish dishInfo;

    @BeforeClass
    public static void connectionPoolInit() throws ConnectionPoolException {
        ConnectionPool.getInstance().initPoolData();
    }

    @Before
    public void initUserInfo() {
        dishInfo = new Dish();
        dishInfo.setId(DISH_ID);
        dishInfo.setTitle(TITLE);
        dishInfo.setDescription(DESCRIPTION);
        dishInfo.setPrice(PRICE);
        dishInfo.setCalorieContent(CALORIE_CONTENT);
        dishInfo.setAvailable(IS_AVAILABLE);
        dishInfo.setPicturePath(PICTURE_PATH);
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

    @Test
    public void getDishTest() throws DAOException{
        Dish expected = dishInfo;
        Dish actual = dishDAO.getDish(DISH_ID);

        Assert.assertEquals(expected, actual);
    }

}
