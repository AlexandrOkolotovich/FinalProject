package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.Order;
import by.jwd.restaurant.service.OrderService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class GoToUserOrdersPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute(SessionAttributes.ATTRIBUTE_USER_ID);

        List<Order> orders = orderService.getUserOrders(userId);

        Date today = new Date();

        request.setAttribute(SessionAttributes.ATTRIBUTE_ORDERS, orders);
        request.setAttribute(SessionAttributes.ATTRIBUTE_TODAY, today);

        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotouserorderspage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/userOrders.jsp");
        requestDispatcher.forward(request, response);
    }
}
