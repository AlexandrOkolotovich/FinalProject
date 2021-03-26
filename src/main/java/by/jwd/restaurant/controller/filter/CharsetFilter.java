package by.jwd.restaurant.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter{
    private String encoding;
    private ServletContext context;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        context.log("Charset was set.");

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter("characterEncoding");
        context = filterConfig.getServletContext();
    }
}
