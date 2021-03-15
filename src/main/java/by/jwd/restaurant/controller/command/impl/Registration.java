package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.bean.RegistrationInfo;
import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.exception.ServiceException;
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

        name = request.getParameter("name");
        surname = request.getParameter("surname");
        phone = request.getParameter("phone");
        email = request.getParameter("email");
        password = request.getParameter("password");

        RegistrationInfo registrationInfo = new RegistrationInfo(name, surname, phone, email, password);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();


        try {
            userService.registration(registrationInfo);

            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);
            response.sendRedirect("Controller?command=gotomainpage");
        } catch (ServiceException e) {
             e.printStackTrace();
            response.sendRedirect("Controller?command=gotologinpage&message=wrong in registration");//Controller?command=gotoindexpage&message=wrong in registration

        }

    }
}
