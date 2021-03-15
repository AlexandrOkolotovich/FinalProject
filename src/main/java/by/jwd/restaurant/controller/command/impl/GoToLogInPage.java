package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoToLogInPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logIn.jsp");
        requestDispatcher.forward(request, response);

    }
}
