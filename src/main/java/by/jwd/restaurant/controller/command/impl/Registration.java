package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.SessionAttributes;
import by.jwd.restaurant.entity.RegistrationInfo;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.entity.Role;
import by.jwd.restaurant.entity.User;
import by.jwd.restaurant.service.MessageManager;
import by.jwd.restaurant.service.exception.ServiceException;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.UserService;

import javax.servlet.RequestDispatcher;
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
        String repeatPassword;

        HttpSession session = request.getSession();

        name = request.getParameter(SessionAttributes.ATTRIBUTE_NAME);
        surname = request.getParameter(SessionAttributes.ATTRIBUTE_SURNAME);
        phone = request.getParameter(SessionAttributes.ATTRIBUTE_PHONE);
        email = request.getParameter(SessionAttributes.ATTRIBUTE_EMAIL);
        password = request.getParameter(SessionAttributes.ATTRIBUTE_PASSWORD);
        repeatPassword = request.getParameter(SessionAttributes.ATTRIBUTE_REPEAT_PASSWORD);

        RegistrationInfo registrationInfo = new RegistrationInfo(name, surname, phone, email, password, repeatPassword);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user;

        try {
            user = userService.registration(registrationInfo);

            session.setAttribute(SessionAttributes.ATTRIBUTE_USER_ROLE, user.getRole());
            session.setAttribute(SessionAttributes.ATTRIBUTE_USER_ID, user.getId());
            session.setAttribute(SessionAttributes.ATTRIBUTE_USER_EMAIL, user.getEmail());
            response.sendRedirect("Controller?command=gotomainpage");
        } catch (ServiceException e) {
            request.setAttribute("errorRepeatPasswordMessage", "error");
            session.setAttribute(SessionAttributes.PAGE, "Controller?command=gotoregistrationpage");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
