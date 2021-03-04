package by.jwd.restaurant.exception;

public class DAOException extends Exception{
    private static final long serialVersionUID = 5579627996438039829L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
