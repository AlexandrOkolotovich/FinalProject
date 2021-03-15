package by.jwd.restaurant.service.validation;

import by.jwd.restaurant.constant.RegularExpressions;

public class UserValidator {
    public static boolean validateName(String name){
        if(name == null){
            return false;
        }
        return name.matches(RegularExpressions.NAME_REGEX);
    }

    public static boolean validateSurname(String surname){
        if(surname == null){
            return false;
        }
        return surname.matches(RegularExpressions.SURNAME_REGEX);
    }

    public static boolean validatePhone(String phone){
        if(phone == null){
            return false;
        }
        return phone.matches(RegularExpressions.PHONE_REGEX);
    }

    public static boolean validateEmail(String email){
        if(email == null){
            return false;
        }
        return email.matches(RegularExpressions.EMAIL_REGEX);
    }

    public static boolean validatePassword(String password){
        if(password == null){
            return false;
        }
        return password.matches(RegularExpressions.PASSWORD_REGEX);
    }
}
