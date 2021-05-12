package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Dish;
import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.UserService;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToPersonalAccountPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        HttpSession session = request.getSession();

        String email = (String) session.getAttribute(SessionAttributes.ATTRIBUTE_USER_EMAIL);

        try {
            User user = userService.getPersonalAccount(email);
            request.setAttribute(SessionAttributes.ATTRIBUTE_USER, user);

        }catch (ServiceException e){
            response.sendRedirect("Controller?command=gotohomepage&message=wrong in catch");
        }

        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotopersonalaccountpage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalAccount.jsp");
        requestDispatcher.forward(request, response);
    }
}
