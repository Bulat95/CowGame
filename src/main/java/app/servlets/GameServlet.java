package app.servlets;
import app.gameplay.Gameplay;
import app.model.Model;
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
    int count = 0;
    int nOfGames = 0;
    String value;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        value = req.getParameter("value");
        if(!startOn || value.equals("0")){
            start();
        }
        req.setAttribute("value", gp.general(value, arr) + " " + count);
        count++;
        Model.actUser.setAverage_num(count /=nOfGames);
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        startOn = false;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game.jsp");
        requestDispatcher.forward(req, resp);
    }

    void start(){
        startOn = true;
        gp = new Gameplay();
        arr = gp.start();
        nOfGames++;
    }

}
