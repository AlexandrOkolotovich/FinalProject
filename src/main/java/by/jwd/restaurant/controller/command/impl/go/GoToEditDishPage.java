package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.RequestParameters;
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

public class GoToEditDishPage implements Command {
    private static final String DISH_ID = RequestParameters.DISH_ID;
    private static final String ATTRIBUTE_DISH = "dish";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Integer id;

        id = Integer.valueOf(request.getParameter(DISH_ID));

        ServiceProvider provider = ServiceProvider.getInstance();
        DishService dishService = provider.getDishService();

        Dish dish = dishService.getDish(id);
        request.setAttribute(ATTRIBUTE_DISH, dish);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/editDish.jsp");
        requestDispatcher.forward(request, response);
    }
}
