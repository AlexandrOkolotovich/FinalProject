package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.service.DishService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMenuPage implements Command {
    private static final String ATTRIBUTE_DISHES = "dishes";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        try {
            List<Dish> dishes = dishService.getDishes();
            request.setAttribute(ATTRIBUTE_DISHES, dishes);
        }catch (ServiceException e){
            response.sendRedirect("Controller?command=gotohomepage&message=wrong in catch");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
        requestDispatcher.forward(request, response);

    }
}
