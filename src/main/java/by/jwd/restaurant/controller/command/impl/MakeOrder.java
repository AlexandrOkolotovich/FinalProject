package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.RegularExpressions;
import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Order;
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
        Date date = null;
        double totalPrice;
        Integer orderId;

        HttpSession session = request.getSession();

        try {
            date = new SimpleDateFormat(RegularExpressions.DATE_REGEX).parse(request.getParameter(SessionAttributes.ATTRIBUTE_DATE));
        } catch (ParseException e) {
            throw new ServiceException("date format exception", e);
        }
        totalPrice = (Double) session.getAttribute(SessionAttributes.ATTRIBUTE_TOTAL_PRICE);
        orderId = (Integer) session.getAttribute(SessionAttributes.ATTRIBUTE_ORDER_ID);

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
