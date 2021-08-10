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

    public Hero() {

    }

    public Hero(String heroName, String heroImage) {
        this.heroName = heroName;
        this.heroImage = heroImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", heroName='" + heroName + '\'' +
                ", heroImage='" + heroImage + '\'' +
                '}';
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
}
