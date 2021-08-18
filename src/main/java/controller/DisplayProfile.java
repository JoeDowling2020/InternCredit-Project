package controller;

import entity.Hero;
import entity.Profile;
import entity.User;
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
        name = "displayProfile", urlPatterns = {"/displayProfile"} )
public class DisplayProfile extends HttpServlet {

    private GenericDao profileDao;
    private GenericDao userDao;

    public void init() {
        userDao = new GenericDao((User.class));
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

        List<User> allUsers = userDao.getAll();
        request.setAttribute("allUsers", allUsers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }
}