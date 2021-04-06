package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewDish implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String title;
        String description;
        double price;
        float calorieContent;
        boolean isAvailable;
        String picturePath;

        title = request.getParameter("title");
        description = request.getParameter("description");
        price = Double.parseDouble(request.getParameter("price"));
        calorieContent = Float.parseFloat(request.getParameter("calorieContent"));
        isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
        picturePath = request.getParameter("picturePath");

        Dish dish = new Dish(title, description, price, calorieContent, isAvailable, picturePath);

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        try {
            dishService.addNewDish(dish);

            response.sendRedirect("Controller?command=gotomainpage");
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomainpage&message=wrong in adding new dish");
        }


    }
}
