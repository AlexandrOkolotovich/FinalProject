package by.jwd.restaurant.controller.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ProjectRequestListener implements ServletRequestListener {
    public ProjectRequestListener(){

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Request from " + request.getContextPath() + " was destroyed.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Request from " + request.getContextPath() + " was created.");
    }
}
