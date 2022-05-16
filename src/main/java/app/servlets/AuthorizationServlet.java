package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthorizationServlet extends HttpServlet {
    String login;
    String password;
    List<User> users;
    boolean hasUser;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("pass");
        users = Model.getInstance().getUsers();
        hasUser = false;
        for (User user : users) {
            if (user.getName().equals(login) && user.getPassword().equals(password)) {
                Model.setActUser(user);
                hasUser = true;
                break;
            }
        }

        if (hasUser) {
            req.setAttribute("userName", login);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", true);
        }
        doGet(req, resp);
    }
}
