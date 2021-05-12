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

    private static final String NEW_NAME = "Алексеев";
    private static final String NEW_SURNAME = "Алексей";
    private static final String NEW_PHONE = "+375294444444";
    private static final String NEW_EMAIL = "test5@mail.ru";
    private static final String NEW_PASSWORD = "zxcvbnm";
    private static final Integer NEW_ROLE_ID = 2;
    private static final Integer WRONG_ROLE_ID = 4;
    private static final Integer USER_ID = 4;
    private static final String USER_EMAIL = "shepelevich@mail.ru";

    private static final String SELECT_NEW_USER_SQL = "SELECT user_id FROM users WHERE user_email='test5@mail.ru'";

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
        RegistrationInfo registrationInfo = new RegistrationInfo(NEW_NAME, NEW_SURNAME, NEW_PHONE, NEW_EMAIL, NEW_PASSWORD, NEW_ROLE_ID);
        userDAO.registration(registrationInfo);

        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_NEW_USER_SQL);
            Assert.assertTrue(resultSet.next());
        }
    }

    @Test(expected = DAOException.class)
    public void createNegativeTest() throws DAOException {
        RegistrationInfo registrationInfo = new RegistrationInfo(NEW_NAME, NEW_SURNAME, NEW_PHONE, NEW_EMAIL, NEW_PASSWORD, WRONG_ROLE_ID);
        userDAO.registration(registrationInfo);
    }

    @Test
    public void findIdTest1() throws DAOException {
        Integer expected = USER_ID;
        Integer actual = userDAO.findId(USER_EMAIL);

        Assert.assertEquals(expected, actual);
    }

}
