package ua.com.mytodo.servlet;

import ua.com.mytodo.model.User;
import ua.com.mytodo.service.AuthService;
import ua.com.mytodo.service.factory.ServiceFactory;
import ua.com.mytodo.service.impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String name = req.getParameter("password");

        User user = new User(name,email,password);

        final User userCheck = ServiceFactory.userServiceImpl().findByEmail(email);

        if (userCheck == null) {
            ServiceFactory.userServiceImpl().save(user);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

        user = ServiceFactory.userServiceImpl().findByEmail(email);

        final HttpSession session = req.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getName());
        session.setAttribute("userEmail", user.getEmail());
        req.getRequestDispatcher("todo/todos.jsp").forward(req, resp);
    }
}
