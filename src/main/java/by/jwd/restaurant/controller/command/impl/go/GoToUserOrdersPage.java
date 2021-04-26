package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.controller.command.Command;
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
import java.util.List;

public class GoToUserOrdersPage implements Command {
    private static final String ATTRIBUTE_ORDERS = "orders";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute("userId");

        List<Order> orders = orderService.getUserOrders(userId);

        request.setAttribute(ATTRIBUTE_ORDERS, orders);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/userOrders.jsp");
        requestDispatcher.forward(request, response);
    }
}
