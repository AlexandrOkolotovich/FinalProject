package by.jwd.restaurant.controller;

import by.jwd.restaurant.controller.command.Command;
import by.jwd.restaurant.controller.command.CommandProvider;
import by.jwd.restaurant.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name;
        Command command;

        name = request.getParameter("command");
        command = provider.takeCommand(name);

        try {
            command.execute(request, response);
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotologinpage&message=wrong in registration");//Controller?command=gotoindexpage&message=wrong in registration
        }
    }
}
