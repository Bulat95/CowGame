package app.servlets;
import app.database.Connection;
import app.database.Person;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PersistenceDelegate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AuthorizationServlet extends HttpServlet {
    Connection connection = new Connection();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");



        req.setAttribute("userName", name);
        doGet(req, resp);
    }

}
