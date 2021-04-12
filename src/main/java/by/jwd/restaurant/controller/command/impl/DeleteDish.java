package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.RequestParameters;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDish implements Command {
    private static final String DISH_ID = RequestParameters.DISH_ID;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer dishId;

        dishId = Integer.valueOf(request.getParameter(DISH_ID));

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        try {
            dishService.makeNotAvailable(dishId);
            response.sendRedirect("Controller?command=gotomenupage&message=success delete dish");
        }catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in delete dish");
        }
    }
}
