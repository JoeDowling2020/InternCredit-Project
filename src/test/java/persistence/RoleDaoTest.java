package persistence;

import entity.Role;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoleDaoTest {
    GenericDao genericDao;
    GenericDao userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Role.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all Roles successfully.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> roles = genericDao.getAll();
        assertEquals(6, roles.size());
        logger.debug(roles);
    }

    /**
     * Verifies a Role is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = (Role)genericDao.getById(1);
        assertEquals("user", retrievedRole.getRole());
        assertEquals("Joe", retrievedRole.getUser().getFirstName());
    }

    /**
     * Verify successful insert of a Role
     */
    @Test
    void insertSuccess() {
        userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(1);
        String userName = user.getUserName();
        String roleName = "admin";
        Role newRole = new Role(user, userName, roleName);
        int id = genericDao.insert(newRole);
        Role insertedRole = (Role)genericDao.getById(id);
        assertEquals(roleName, insertedRole.getRole());
        assertEquals(userName, insertedRole.getUserName());
    }


    /**
     * Verify successful delete of Role
     */
    @Test
    void deleteSuccess() {
        userDao = new GenericDao(User.class);
        genericDao.delete(genericDao.getById(1));
        User existingUser = (User)userDao.getById(1);
        assertNull(genericDao.getById(1));
        assertEquals(existingUser, userDao.getById(1));
    }

    /**
     * Verify successful update of Role
     */
    @Test
    void updateSuccess() {
        String newTitle = "SuperUser";
        Role RoleToUpdate = (Role)genericDao.getById(1);
        RoleToUpdate.setRole(newTitle);
        genericDao.saveOrUpdate(RoleToUpdate);
        Role retrievedRole = (Role)genericDao.getById(1);
        assertEquals(newTitle, retrievedRole.getRole());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> Roles = genericDao.getByPropertyLike("role", "u");
        assertEquals(4, Roles.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> Roles = genericDao.getByPropertyEqual("role", "user");
        assertEquals(4, Roles.size());
    }

}
