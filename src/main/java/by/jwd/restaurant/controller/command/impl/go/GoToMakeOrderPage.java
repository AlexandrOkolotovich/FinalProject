package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
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

public class GoToMakeOrderPage implements Command {
    private static final String ATTRIBUTE_ORDERED_DISHES = "orderedDishes";
    private static final String ATTRIBUTE_TOTAL_PRICE = "totalPrice";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer orderId;
        Double totalPrice;

        HttpSession session = request.getSession();

        orderId = (Integer) session.getAttribute("orderId");

        if(orderId == null) {
            response.sendRedirect("Controller?command=gotomainpage&message=not orders");
            return;
        }

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();
        OrderService orderService = provider.getOrderService();

        try {
            List<Dish> orderedDishes = dishService.getOrderedDishes(orderId);
            totalPrice = orderService.getTotalPrice(orderedDishes);

            request.setAttribute(ATTRIBUTE_ORDERED_DISHES, orderedDishes);
        //    request.setAttribute(ATTRIBUTE_TOTAL_PRICE, totalPrice);
            session.setAttribute(ATTRIBUTE_TOTAL_PRICE, totalPrice);

        }catch (ServiceException e){
            response.sendRedirect("Controller?command=gotohomepage&message=wrong in catch");
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/makeOrder.jsp");
        requestDispatcher.forward(request, response);
    }
}
