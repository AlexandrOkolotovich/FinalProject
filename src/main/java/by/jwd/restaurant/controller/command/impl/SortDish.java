package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.controller.command.CommandName;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SortDish implements Command {
    private static final String PARAMETER_COMMAND = "command";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        HttpSession session = request.getSession();

        List<Dish> sortDishes = null;

        CommandName command = CommandName.valueOf(request.getParameter(PARAMETER_COMMAND).toUpperCase());

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        try {
            switch (command){
                case SORTDISHBYTITLE:{
                    sortDishes =  dishService.sortDishByTitle();
                    break;
                }
                case SORTDISHBYPRICEUP:{
                    sortDishes =  dishService.sortDishByPriceUp();
                    break;
                }
                case SORTDISHBYPRICEDOWN:{
                    sortDishes =  dishService.sortDishByPriceDown();
                    break;
                }
                default:{
                    response.sendRedirect("Controller?command=gotomenupage&message=wrong in sort");
                    break;
                }
            }

            request.setAttribute(SessionAttributes.ATTRIBUTE_DISHES, sortDishes);
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in sort");
        }

        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotomenupage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
        requestDispatcher.forward(request, response);
    }
}
