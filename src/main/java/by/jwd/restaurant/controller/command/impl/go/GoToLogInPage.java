package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class GoToLogInPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotologinpage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logIn.jsp");
        requestDispatcher.forward(request, response);

    }
}
