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

    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getPrimaryHero() {
        return primaryHero;
    }

    public void setPrimaryHero(String primaryHero) {
        this.primaryHero = primaryHero;
    }

    public int getQpWinRate() {
        return qpWinRate;
    }

    public void setQpWinRate(int qpWinRate) {
        this.qpWinRate = qpWinRate;
    }

    public String getQpPlayTime() {
        return qpPlayTime;
    }

    public void setQpPlayTime(String qpPlayTime) {
        this.qpPlayTime = qpPlayTime;
    }

    public String getQpPrimaryHero() {
        return qpPrimaryHero;
    }

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
        return id == profile.id && level == profile.level && winRate == profile.winRate && qpWinRate == profile.qpWinRate && Objects.equals(user, profile.user) && Objects.equals(ign, profile.ign) && Objects.equals(playTime, profile.playTime) && Objects.equals(primaryHero, profile.primaryHero) && Objects.equals(qpPlayTime, profile.qpPlayTime) && Objects.equals(qpPrimaryHero, profile.qpPrimaryHero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, ign, level, winRate, playTime, primaryHero, qpWinRate, qpPlayTime, qpPrimaryHero);
    }
}
