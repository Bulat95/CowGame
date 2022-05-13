package app.servlets;

import app.database.Connection;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    Model model = Model.getInstance();
    User user;
    String login;
    String password;
    Connection conn;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("pass");
        user = new User(login, password, 0, 0,0);
        model.checkArrayAddUser(user); // Регистрация и добавление пользователя
        conn = new Connection();
        try {
            conn.writeToJson(model.getUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("userName", login);
        doGet(req, resp);
    }
}