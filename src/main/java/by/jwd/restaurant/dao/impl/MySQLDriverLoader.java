package by.jwd.restaurant.dao.impl;

import by.jwd.restaurant.exception.DBDriverLoadingException;

public class MySQLDriverLoader {
    private static final MySQLDriverLoader instance = new MySQLDriverLoader();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DBDriverLoadingException(e);
        }
    }

    private MySQLDriverLoader() {}

    public static MySQLDriverLoader getInstance() {
        return instance;
    }
}
