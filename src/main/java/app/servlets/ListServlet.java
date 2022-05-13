package app.servlets;

import app.model.Model;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    Model model;
    List<String> names;
    List<String> namesAndResult;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model = Model.getInstance();
        names = model.list(); // Заполнение массива пользователей
        req.setAttribute("userNames", namesAndResult);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}