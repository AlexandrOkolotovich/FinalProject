package by.jwd.restaurant.service.validation;

import by.jwd.restaurant.constant.RegularExpressions;

public class UserValidator {
    private final static String EMPTY_STRING = "";

    public static boolean validateName(String name){
        if(name == null || name.equals(EMPTY_STRING)){
            return false;
        }
        return name.matches(RegularExpressions.NAME_REGEX);
    }

    public static boolean validateSurname(String surname){
        if(surname == null || surname.equals(EMPTY_STRING)){
            return false;
        }
        return surname.matches(RegularExpressions.SURNAME_REGEX);
    }

    public static boolean validatePhone(String phone){
        if(phone == null || phone.equals(EMPTY_STRING)){
            return false;
        }
        return phone.matches(RegularExpressions.PHONE_REGEX);
    }

    public static boolean validateEmail(String email){
        if(email == null || email.equals(EMPTY_STRING)){
            return false;
        }
        return email.matches(RegularExpressions.EMAIL_REGEX);
    }

    public static boolean validatePassword(String password){
        if(password == null || password.equals(EMPTY_STRING)){
            return false;
        }
        return password.matches(RegularExpressions.PASSWORD_REGEX);
    }

    public static boolean validateRepeatPassword(String repeatPassword, String password) {
        return repeatPassword.equals(password);
    }
}
