package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;

@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_users_id_fk"))
    private User user;

    public Role() {
        //Tried and true no arg constructor!
    }

    /**
     *
     * @param user
     * @param userName
     * @param role
     */
    public Role(User user, String userName, String role) {
        this.user = user;
        this.userName = userName;
        this.role = role;
    }

    /**
     * Get the ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the UserName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the UserName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the Role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the Role
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id && Objects.equals(userName, role1.userName)
                && Objects.equals(role, role1.role) && Objects.equals(user, role1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, role, user);
    }
}
