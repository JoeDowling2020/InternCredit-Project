package controller;

import entity.Hero;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "allHeroes", urlPatterns = {"/allHeroes"} )
public class DisplayHeroes extends HttpServlet {

    private GenericDao heroDao;

    public void init() {
        heroDao = new GenericDao(Hero.class);
    }

    /**
     * Method to retrieve Heroes from the DB
     * before passing them to a web page
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Hero> allHeroes = heroDao.getAll();
        request.setAttribute("allHeroes", allHeroes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/heroes.jsp");
        dispatcher.forward(request, response);
    }
}
