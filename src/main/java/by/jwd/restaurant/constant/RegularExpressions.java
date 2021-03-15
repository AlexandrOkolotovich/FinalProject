package by.jwd.restaurant.constant;

public class RegularExpressions {
    public static final String NAME_REGEX = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
    public static final String SURNAME_REGEX = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
    public static final String PHONE_REGEX = "^((\\+375))((29|44|33|25))[\\d]{7}$";
    public static final String EMAIL_REGEX = "^([a-zA-Z0-9_-]+\\.)*[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*\\.[a-zA-Z]{2,6}$";
    public static final String PASSWORD_REGEX = "^[a-zA-Z0-9]{6,15}$";

}
