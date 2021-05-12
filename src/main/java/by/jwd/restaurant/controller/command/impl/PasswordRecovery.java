package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.constant.RequestParameters;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.service.EmailService;
import by.jwd.restaurant.service.ServiceProvider;
import by.jwd.restaurant.service.UserService;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PasswordRecovery implements Command {
    private static final String LOGIN_EMAIL = RequestParameters.LOGIN_EMAIL;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String email;
        String password;

        email = request.getParameter(LOGIN_EMAIL);

        ServiceProvider provider = ServiceProvider.getInstance();
        EmailService emailService = provider.getEmailService();
        UserService userService = provider.getUserService();

        try {
            password = userService.getUserPassword(email);
            emailService.mail(email, password);
        }
        catch (ServiceException e){
            response.sendRedirect("Controller?command=gotoregistrationpage&message=wrong in password send");
        }

        response.sendRedirect("Controller?command=gotologinpage&message=password send");
    }
}
