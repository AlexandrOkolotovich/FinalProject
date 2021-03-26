package by.jwd.restaurant.service.exception;

import java.util.List;

public class ServiceException extends Exception{
    private static final long serialVersionUID = 1L;

    private List<String> errorDescription;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }

    public ServiceException(String message, List <String> errorDescription) {
        super(message);
        this.errorDescription = errorDescription;
    }

    public List<String> getErrorDescription() {
        return errorDescription;
    }

}
