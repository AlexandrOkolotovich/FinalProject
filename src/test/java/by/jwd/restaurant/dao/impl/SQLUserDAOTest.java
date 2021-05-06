package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.UserDAO;
import by.jwd.restaurant.dao.connection.ConnectionPool;
import by.jwd.restaurant.dao.exception.ConnectionPoolException;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.RegistrationInfo;
import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUserDAOTest {

    private static final String NEW_NAME = "Имя";
    private static final String NEW_SURNAME = "Фамилия";
    private static final String NEW_PHONE = "+375333333333";
    private static final String NEW_EMAIL = "test@mail.ru";
    private static final String NEW_PASSWORD = "123456";
    private static final String WRONG_NAME = "Alex";
    private static final long USER_ID = 1L;
    private static final String USER_EMAIL = "shepelevich@mail.ru";

    private static final String SELECT_NEW_USER_SQL = "SELECT user_id FROM users WHERE user_email='test@mail.ru'";

    private static final UserDAO userDAO = DAOProvider.getInstance().getUserDAO();

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
        RegistrationInfo registrationInfo = new RegistrationInfo(NEW_NAME, NEW_SURNAME, NEW_PHONE, NEW_EMAIL, NEW_PASSWORD);
        userDAO.registration(registrationInfo);

        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_NEW_USER_SQL);
            Assert.assertTrue(resultSet.next());
        }
    }

    @Test(expected = DAOException.class)
    public void createNegativeTest() throws DAOException {
        RegistrationInfo registrationInfo = new RegistrationInfo(WRONG_NAME, NEW_SURNAME, NEW_PHONE, NEW_EMAIL, NEW_PASSWORD);
        userDAO.registration(registrationInfo);
    }

    @Test
    public void findIdTest1() throws DAOException {
        Long expected = USER_ID;
        Long actual = Long.valueOf(userDAO.findId(USER_EMAIL));

        Assert.assertEquals(expected, actual);
    }


}
