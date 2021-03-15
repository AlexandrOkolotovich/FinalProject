package by.jwd.restaurant.controller.command.impl;

import by.jwd.restaurant.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session!=null){
            session.removeAttribute("auth");
        }

        response.sendRedirect("Controller?command=gotologinpage&message=logout ok");
    }
}
