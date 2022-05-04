package app.servlets;


import app.gameplay.Gameplay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GameServlet extends HttpServlet {
    int [] arr;
    boolean startOn;
    Gameplay gp;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        //
        if(!startOn){
            startOn = true;
            gp = new Gameplay();
            arr = gp.start();
        }

        req.setAttribute("value", gp.general(value, arr));

        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game.jsp");
        requestDispatcher.forward(req, resp);
    }
}
