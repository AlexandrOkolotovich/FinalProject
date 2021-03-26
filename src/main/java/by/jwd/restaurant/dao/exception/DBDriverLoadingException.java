package by.jwd.restaurant.dao.exception;

public class DBDriverLoadingException extends RuntimeException{
    public DBDriverLoadingException(Exception e){
        super(e);
    }
}
