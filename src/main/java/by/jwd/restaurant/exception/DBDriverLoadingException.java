package by.jwd.restaurant.exception;

public class DBDriverLoadingException extends RuntimeException{
    public DBDriverLoadingException(Exception e){
        super(e);
    }
}
