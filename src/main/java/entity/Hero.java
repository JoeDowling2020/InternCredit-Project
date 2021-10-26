package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;

@Entity(name = "Hero")
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "heroName")
    private String heroName;

    @Column(name = "heroImage")
    private String heroImage;

    @Column(name = "heroLink")
    private String heroLink;

    public Hero() {
        //Tried and true no arg constructor!
    }

    /**
     * @param heroName the heroes name
     * @param heroImage the heroes image
     */
    public Hero(String heroName, String heroImage) {
        this.heroName = heroName;
        this.heroImage = heroImage;
    }


    /**
     * Get the Hero ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Hero ID
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the Hero Name
     * @return heroName
     */
    public String getHeroName() {
        return heroName;
    }

    /**
     * Set Hero Name
     * @param heroName the hero name
     */
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    /**
     * Get Hero Image
     * @return heroImage
     */
    public String getHeroImage() {
        return heroImage;
    }

    /**
     * Set Hero Image
     * @param heroImage the hero image
     */
    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return id == hero.id && Objects.equals(heroName, hero.heroName) && Objects.equals(heroImage, hero.heroImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heroName, heroImage);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", heroName='" + heroName + '\'' +
                ", heroImage='" + heroImage + '\'' +
                '}';
    }
}
