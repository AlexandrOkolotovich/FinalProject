package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;
import by.jwd.restaurant.service.impl.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToOrder implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer dishId;
        Integer orderId;

        dishId = Integer.valueOf(request.getParameter("dishId"));
        orderId = Integer.valueOf(request.getParameter("orderId"));

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        OrderService orderService = serviceProvider.getOrderService();

        try {
            orderService.addDishToOrder(dishId, orderId);
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in adding dish to order");
        }
    }
}
