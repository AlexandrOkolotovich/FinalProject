package by.jwd.restaurant.service.validation;

import by.jwd.restaurant.constant.RegularExpressions;

public class DishValidator {
    private final static String EMPTY_STRING = "";

    public static boolean validateTitle(String title) {
        if(title == null || title.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    public static boolean validateDescription(String description) {
        if(description == null || description.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    public static boolean validatePrice(double price) {
        if(price < 0){
            return false;
        }
        return true;
    }

    public static boolean validateCalorieContent(float calorieContent) {
        if(calorieContent < 0){
            return false;
        }
        return true;
    }

    public static boolean validatePicturePath(String picturePath) {
        if(picturePath == null || picturePath.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }
}
