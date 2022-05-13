package app.servlets;
import app.gameplay.Gameplay;
import app.model.ActualUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GameServlet extends HttpServlet {
    Gameplay gp;
    String value;
    boolean startOn;
    int [] arr;
    int count = 1;
    int nOfGames = 0;
    ActualUser actualUser = ActualUser.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        value = req.getParameter("value");
        if (!startOn || value.equals("0")) {
            start();
            actualUser.setNumberOfGames(nOfGames);
        }
        req.setAttribute("value", gp.general(value, arr) + "  Попытка: " + count);
        count++;
        actualUser.setNumberOfGames(count);
        doGet(req, resp);
    }



    void start() {
        startOn = true;
        gp = new Gameplay();
        arr = gp.start();
        nOfGames++;
    }
}
