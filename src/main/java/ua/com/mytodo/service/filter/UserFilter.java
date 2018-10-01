package ua.com.mytodo.service.filter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final Long userId = (Long) req.getSession().getAttribute("userId");
        if (userId != null) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("../error.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
