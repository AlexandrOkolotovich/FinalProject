package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.jwd.restaurant.constant.RequestParameters.DISH_ID;

public class UpdateDish implements Command {
    private static final String PATH_TO_PICTURE = "/static/img/";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer id;
        String title;
        String description;
        double price;
        float calorieContent;
        boolean isAvailable;
        String picturePath;

        id = Integer.valueOf(request.getParameter(DISH_ID));

        title = request.getParameter(SessionAttributes.TITLE);
        description = request.getParameter(SessionAttributes.ATTRIBUTE_DESCRIPTION);
        price = Double.parseDouble(request.getParameter(SessionAttributes.ATTRIBUTE_PRICE));
        calorieContent = Float.parseFloat(request.getParameter(SessionAttributes.ATTRIBUTE_CALORIE_CONTENT));
        isAvailable = Boolean.parseBoolean(request.getParameter(SessionAttributes.ATTRIBUTE_IS_AVAILABLE));
        picturePath = PATH_TO_PICTURE + request.getParameter(SessionAttributes.ATTRIBUTE_PICTURE_PATH);

        Dish dish = new Dish(id, title, description, price, calorieContent, isAvailable, picturePath);

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        try {
            dishService.updateDish(dish);

            response.sendRedirect("Controller?command=gotomenupage");
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in updating new dish");
        }
    }
}
