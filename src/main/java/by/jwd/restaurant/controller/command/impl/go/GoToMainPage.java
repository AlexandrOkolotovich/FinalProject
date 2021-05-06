package by.jwd.restaurant.controller.command.impl.go;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToMainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session == null) {
            response.sendRedirect("Controller?command=gotohomepage&message=eeerrror2");
            return;
        }

        Integer id = null;

        if(session.getAttribute(SessionAttributes.ATTRIBUTE_USER_ROLE) == Role.ADMIN){
            id = (Integer) session.getAttribute(SessionAttributes.ATTRIBUTE_USER_ID);
        } else if(session.getAttribute(SessionAttributes.ATTRIBUTE_USER_ROLE) == Role.USER){
            id = (Integer) session.getAttribute(SessionAttributes.ATTRIBUTE_USER_ID);
        }
        session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotomainpage");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        requestDispatcher.forward(request, response);
    }
}
