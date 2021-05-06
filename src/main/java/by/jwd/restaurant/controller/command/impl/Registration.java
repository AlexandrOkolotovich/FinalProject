package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.entity.RegistrationInfo;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Role;
import by.jwd.restaurant.service.exception.ServiceException;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Registration implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        String surname;
        String phone;
        String email;
        String password;

        name = request.getParameter(SessionAttributes.ATTRIBUTE_NAME);
        surname = request.getParameter(SessionAttributes.ATTRIBUTE_SURNAME);
        phone = request.getParameter(SessionAttributes.ATTRIBUTE_PHONE);
        email = request.getParameter(SessionAttributes.ATTRIBUTE_EMAIL);
        password = request.getParameter(SessionAttributes.ATTRIBUTE_PASSWORD);

        RegistrationInfo registrationInfo = new RegistrationInfo(name, surname, phone, email, password);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        try {
            userService.registration(registrationInfo);

            HttpSession session = request.getSession(true);

            session.setAttribute(SessionAttributes.ATTRIBUTE_USER_ROLE, Role.USER);
            response.sendRedirect("Controller?command=gotomainpage");
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoregistrationpage&message=wrong in registration");

        }

    }
}
