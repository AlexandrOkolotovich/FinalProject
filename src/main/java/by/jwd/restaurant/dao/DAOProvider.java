package by.jwd.restaurant.dao;

import by.jwd.restaurant.dao.impl.SQLUserDAO;

public final class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userdao = new SQLUserDAO();
    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userdao;
    }

}
