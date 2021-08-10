package persistence;

import entity.Role;
import entity.User;
import entity.Hero;
import entity.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HeroDaoTest {
    GenericDao genericDao;
    GenericDao userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Hero.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllHeroesSuccess() {
        List<Hero> hero = genericDao.getAll();
        assertEquals(32, hero.size());
    }

    @Test
    void getByIdSuccess() {
        Hero retrievedHero = (Hero)genericDao.getById(1);
        assertEquals(1, retrievedHero.getId());
        assertEquals("ana", retrievedHero.getHeroName());
    }

    @Test
    void insertSuccess() {
        String heroName = "Sojourn";
        Hero newHero = new Hero("Sojourn", "https://static.wikia.nocookie.net/overwatch_gamepedia/images/a/a6/Sojourn-ow2.jpg/revision/latest/scale-to-width-down/350?cb=20191106010714");
        int id = genericDao.insert(newHero);
        Hero insertedHero = (Hero)genericDao.getById(id);
        assertEquals(heroName, insertedHero.getHeroName());
    }

    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        Hero existingHero = (Hero)genericDao.getById(1);
        assertNull(genericDao.getById(1));
        assertEquals(existingHero, genericDao.getById(1));
    }

    @Test
    void updateSuccess() {
        String newHero = "Anna";
        Hero heroToUpdate = (Hero)genericDao.getById(1);
        heroToUpdate.setHeroName(newHero);
        genericDao.saveOrUpdate(heroToUpdate);
        Hero retrievedHero = (Hero)genericDao.getById(1);
        assertEquals(newHero, retrievedHero.getHeroName());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Hero> heroes = genericDao.getByPropertyLike("heroName", "b");
        assertEquals(6, heroes.size());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Hero> heroes = genericDao.getByPropertyEqual("heroName", "hanzo");
        assertEquals(1, heroes.size());
    }
}
