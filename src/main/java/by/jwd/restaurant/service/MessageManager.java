package by.jwd.restaurant.service;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("locale");

    private MessageManager(){}

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
