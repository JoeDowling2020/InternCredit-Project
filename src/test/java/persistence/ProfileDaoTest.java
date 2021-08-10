package persistence;

import entity.Role;
import entity.User;
import entity.Hero;
import entity.Profile;
import properties.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileDaoTest {
    GenericDao genericDao;
    GenericDao userDao;
    GenericDao profileDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Profile.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllProfilesSuccess() {
        List<Profile> profiles = genericDao.getAll();
        assertEquals(1, profiles.size());
    }

    @Test
    void getByIdSuccess() {
        Profile retrievedProfile = (Profile)genericDao.getById(1);
        assertNotNull(retrievedProfile);
        assertEquals("FractalMan#2913", retrievedProfile.getIgn());
    }

    @Test
    void insertSuccess() {
        userDao = new GenericDao(User.class);
        profileDao = new GenericDao(Profile.class);
        User user = (User)userDao.getById(1);
        Profile newProfile = new Profile(user, "Fr0sty#2913", 322, 72, "2hr 24min", "ana", 51, "14d 2hr 24m", "ana");
        int id = profileDao.insert(newProfile);
        assertNotEquals(0,id);
        Profile insertedUser = (Profile)genericDao.getById(id);
        assertEquals(newProfile, insertedUser);
    }

    @Test
    void deleteSuccess() {
        userDao = new GenericDao(User.class);
        profileDao = new GenericDao(Profile.class);
        profileDao.delete(profileDao.getById(1));
        Profile existingProfile = (Profile)profileDao.getById(1);
        assertNull(profileDao.getById(1));
        assertEquals(existingProfile, profileDao.getById(1));
    }

    @Test
    void updateSuccess() {
        String newHero = "Bastion";
        Profile profileToUpdate = (Profile)genericDao.getById(1);
        profileToUpdate.setPrimaryHero(newHero);
        genericDao.saveOrUpdate(profileToUpdate);
        Profile retrievedProfile = (Profile)genericDao.getById(1);
        assertEquals(newHero, retrievedProfile.getPrimaryHero());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Profile> profiles = genericDao.getByPropertyLike("qpPlayTime", "14d");
        assertEquals(1, profiles.size());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Profile> profiles = genericDao.getByPropertyEqual("qpPlayTime", "14d 2hr 24m");
        assertEquals(1, profiles.size());
    }
}
