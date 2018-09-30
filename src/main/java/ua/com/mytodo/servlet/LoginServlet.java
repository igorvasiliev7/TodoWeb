package ua.com.mytodo.servlet;

import ua.com.mytodo.model.User;
import ua.com.mytodo.service.AuthService;
import ua.com.mytodo.service.impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        AuthService authService = new AuthServiceImpl();
        final User user = authService.login(email, password);

        if (user == null) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        final HttpSession session = req.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getName());
        session.setAttribute("userEmail", user.getEmail());
        req.getRequestDispatcher("todo/todos.jsp").forward(req, resp);
    }
}
