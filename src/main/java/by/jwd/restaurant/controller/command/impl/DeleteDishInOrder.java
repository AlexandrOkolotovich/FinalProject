package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteDishInOrder implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer dishId;
        Integer orderId;

        HttpSession session = request.getSession();

        dishId = Integer.valueOf(request.getParameter(SessionAttributes.ATTRIBUTE_DISH_ID));
        orderId = (Integer) session.getAttribute(SessionAttributes.ATTRIBUTE_ORDER_ID);

        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        try{
            orderService.deleteDishInOrder(dishId, orderId);
            response.sendRedirect("Controller?command=gotomakeorderpage&message=delete dish ok");
        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomenupage&message=wrong in delete dish in order");
        }
    }
}
