package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDishInOrder implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer orderedDishId;

        orderedDishId = Integer.valueOf(request.getParameter("orderedDishId"));

        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        try{
            orderService.deleteDishInOrder(orderedDishId);
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in delete dish in order");
        }
    }
}
