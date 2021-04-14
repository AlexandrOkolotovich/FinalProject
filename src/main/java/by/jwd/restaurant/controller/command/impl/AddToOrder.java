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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToOrder implements Command {
    private static final String ATTRIBUTE_ORDER_ID = "orderId";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer dishId;
        Integer orderId;
        Integer userId;

        HttpSession session = request.getSession();

        dishId = Integer.valueOf(request.getParameter("dishId"));
        userId = (Integer) session.getAttribute("userId");

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        OrderService orderService = serviceProvider.getOrderService();

        try {
            orderId = orderService.getOrderId(userId);

            if(orderId == null){
                orderService.makeNewOrder(userId);
                orderId = orderService.getOrderId(userId);

            }

            session.setAttribute(ATTRIBUTE_ORDER_ID, orderId);

            orderService.addDishToOrder(dishId, orderId);

            response.sendRedirect("Controller?command=gotomenupage");
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in adding dish to order");
        }
    }
}
