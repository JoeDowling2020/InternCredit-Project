package controller;

import entity.Hero;
import entity.Profile;
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
public class DisplayProfile extends HttpServlet {

    private GenericDao profileDao;

    public void init() {
        profileDao = new GenericDao(Profile.class);
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

        List<Profile> allProfiles = profileDao.getAll();
        request.setAttribute("allProfiles", allProfiles);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allHeroes.jsp");
        dispatcher.forward(request, response);
    }
}