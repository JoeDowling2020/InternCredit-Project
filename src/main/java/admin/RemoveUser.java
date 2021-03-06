package admin;

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

/**
 * Method to remove a user via the admin page
 */
@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {
    private GenericDao userDao;
    private GenericDao profileDao;
    private int selectedUserId;

    /**
     * Method to set up the User Dao
     */
    public void init() {
        profileDao = new GenericDao((Profile.class));
        userDao = new GenericDao(User.class);
    }

    /**
     * Method to the user ID to be deleted
     * and remove them from the database
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        selectedUserId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(selectedUserId);
        userDao.delete(userDao.getById(selectedUserId));;
        RequestDispatcher dispatcher = request.getRequestDispatcher("/removalSuccess.jsp");
        dispatcher.forward(request, response);
    }
}