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

import static java.lang.System.out;


public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");


        List<User> users = Model.getInstance().getUsers();
        boolean hasUser = false;
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                hasUser = true;
                break;
            }
        }

        if (hasUser){
            req.setAttribute("userName", name);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", true);
        }
        doGet(req, resp);

    }

}
