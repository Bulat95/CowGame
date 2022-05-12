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
import java.util.List;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        int average_num = 0;
        int numberOfGames = 0;
        User user = new User(name, password, average_num, numberOfGames);
        Model model = Model.getInstance();
        model.checkInitArray(user);
        Connection conn = new Connection();
        try {
            conn.writeToJson(model.getUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}