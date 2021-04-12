package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToHomePage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
