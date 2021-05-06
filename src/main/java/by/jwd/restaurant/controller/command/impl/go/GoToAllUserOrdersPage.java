package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.SessionAttributes;
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
import java.util.Date;
import java.util.List;

public class GoToAllUserOrdersPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        OrderService orderService = provider.getOrderService();

        HttpSession session = request.getSession();

        List<Order> orders = orderService.getAllOrders();

        Date today = new Date();

        request.setAttribute(SessionAttributes.ATTRIBUTE_ORDERS, orders);
        request.setAttribute(SessionAttributes.ATTRIBUTE_TODAY, today);

        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotoalluserorderspage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/userOrders.jsp");
        requestDispatcher.forward(request, response);
    }
}
