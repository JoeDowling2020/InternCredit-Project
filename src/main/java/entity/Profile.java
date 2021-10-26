package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;

@Entity(name = "Profile")
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "profile_user_id_fk"))
    private User user;

    @Column(name = "ign")
    private String ign;

    @Column(name = "level")
    private int level;

    @Column(name = "winRate")
    private int winRate;

    @Column(name = "playTime")
    private String playTime;

    @Column(name = "primaryHero")
    private  String primaryHero;

    @Column(name = "qpWinRate")
    private int qpWinRate;

    @Column(name = "")
    private String qpPlayTime;

    @Column(name = "")
    private  String qpPrimaryHero;


    public Profile() {
        //Tried and true no arg constructor!
    }

    /**
     *
     * @param user The User
     * @param ign The User's In Game Name
     * @param level The User's Level
     * @param winRate The User's Win Rate
     * @param playTime The User's Play Time
     * @param primaryHero The User's Primary Hero
     * @param qpWinRate The User's Quick Play Win Rate
     * @param qpPlayTime The User's Quick Play Play Time
     * @param qpPrimaryHero The User's Quick Play Primary Hero
     */
    public Profile(User user, String ign, int level, int winRate, String playTime, String primaryHero, int qpWinRate,
                   String qpPlayTime, String qpPrimaryHero) {
//        this.id = id;
        this.user = user;
        this.ign = ign;
        this.level = level;
        this.winRate = winRate;
        this.playTime = playTime;
        this.primaryHero = primaryHero;
        this.qpWinRate = qpWinRate;
        this.qpPlayTime = qpPlayTime;
        this.qpPrimaryHero = qpPrimaryHero;

    }

    /**
     * Get the Profile ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Profile ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the User
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the User
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the In Game Name
     * @return ign
     */
    public String getIgn() {
        return ign;
    }

    /**
     * Set the In Game Name
     * @param ign
     */
    public void setIgn(String ign) {
        this.ign = ign;
    }

    /**
     * Get the Player Level
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the Player Level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the Win Rate
     * @return winRate
     */
    public int getWinRate() {
        return winRate;
    }

    /**
     * Set the Win Rate
     * @param winRate
     */
    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    /**
     * Get the Play Time
     * @return playTime
     */
    public String getPlayTime() {
        return playTime;
    }

    /**
     * Set Play Time
     * @param playTime
     */
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    /**
     * Get Primary Hero
     * @return primaryHero
     */
    public String getPrimaryHero() {
        return primaryHero;
    }

    /**
     * Set Primary Hero
     * @param primaryHero
     */
    public void setPrimaryHero(String primaryHero) {
        this.primaryHero = primaryHero;
    }

    /**
     * Get Quick Play Win Rate
     * @return qpWinRate
     */
    public int getQpWinRate() {
        return qpWinRate;
    }

    /**
     * Set Quick Play Win Rate
     * @param qpWinRate
     */
    public void setQpWinRate(int qpWinRate) {
        this.qpWinRate = qpWinRate;
    }

    /**
     * Get Quick Play Time
     * @return qpPlayTime
     */
    public String getQpPlayTime() {
        return qpPlayTime;
    }

    /**
     * Set Quick Play Time
     * @param qpPlayTime
     */
    public void setQpPlayTime(String qpPlayTime) {
        this.qpPlayTime = qpPlayTime;
    }

    /**
     * Get Quick Play Primary Hero
     * @return qpPrimaryHero
     */
    public String getQpPrimaryHero() {
        return qpPrimaryHero;
    }

    /**
     * Set Quick Play Primary Hero
     * @param qpPrimaryHero
     */
    public void setQpPrimaryHero(String qpPrimaryHero) {
        this.qpPrimaryHero = qpPrimaryHero;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", user=" + user +
                ", ign='" + ign + '\'' +
                ", level=" + level +
                ", winRate=" + winRate +
                ", playTime='" + playTime + '\'' +
                ", primaryHero='" + primaryHero + '\'' +
                ", qpWinRate=" + qpWinRate +
                ", qpPlayTime='" + qpPlayTime + '\'' +
                ", qpPrimaryHero='" + qpPrimaryHero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id && level == profile.level && winRate == profile.winRate
                && qpWinRate == profile.qpWinRate && Objects.equals(user, profile.user)
                && Objects.equals(ign, profile.ign) && Objects.equals(playTime, profile.playTime)
                && Objects.equals(primaryHero, profile.primaryHero) && Objects.equals(qpPlayTime, profile.qpPlayTime)
                && Objects.equals(qpPrimaryHero, profile.qpPrimaryHero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, ign, level, winRate, playTime, primaryHero, qpWinRate, qpPlayTime, qpPrimaryHero);
    }
}
