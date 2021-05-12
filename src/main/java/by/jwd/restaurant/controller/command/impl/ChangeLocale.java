package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLocale implements Command {
    private static final String PARAMETER_COMMAND = "command";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.LOCALE, request.getParameter(PARAMETER_COMMAND));

        String page;

        if (request.getParameter(SessionAttributes.PAGE) != null) {
            page = request.getParameter(SessionAttributes.PAGE);
        } else if (session.getAttribute(SessionAttributes.PAGE) != null) {
            page = (String) session.getAttribute(SessionAttributes.PAGE);
        } else {
            page = SessionAttributes.INDEX_PAGE;
        }
        response.sendRedirect(page);
    }
}
