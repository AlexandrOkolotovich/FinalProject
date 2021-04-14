package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.entity.OrderStatus;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeOrder implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String dateStr;
        double totalPrice;
        Integer orderId;

        HttpSession session = request.getSession();

        dateStr = request.getParameter("date");
        totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        orderId = (Integer) session.getAttribute("orderId");

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = in.parse(dateStr);
        } catch (ParseException e) {
            throw new ServiceException("date parser exception", e);
        }

        Order order = new Order(date, totalPrice, orderId);

        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        try {
            orderService.makeOrder(order);
            response.sendRedirect("Controller?command=gotomainpage&message=success at make order");

        } catch (ServiceException e){
            response.sendRedirect("Controller?command=gotomainpage&message=wrong in make order");
        }
    }
}
