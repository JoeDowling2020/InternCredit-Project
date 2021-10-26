package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;

@Entity(name = "User")
@Table(name="user") // Case matters!
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name= "native",strategy= "native")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Profile> profiles = new HashSet<>();


    public User() {
        //Tried and true no arg constructor!
    }

    /**
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param userName the user's username
     * @param password the user's password
     */
    public User(String firstName, String lastName, String userName, String password) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this. password = password;
    }

    /**
     * Get ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set ID
     * @param id the user's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get First Name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set First Name
     * @param firstName the user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get Last Name
     * @return lastName the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Last Name
     * @param lastName the user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get Username
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set Username
     * @param userName the user's username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get Password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Passwords
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * gets Roles set
     * @return roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the Roles Set
     * @param roles users role
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Adds a role to the user
     * @param role users role
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    /**
     * removes the users role
     * @param role the users role
     */
    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser( null );
    }

    /**
     * Gets Profiles
     * @return profiles
     */
    public Set<Profile> getProfiles() {
        return profiles;
    }

    /**
     * Sets Profiles
     * @param profiles the profiles
     */
    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    /**
     * Add Profile
     * @param profile the user's profile
     */
    public void addProfile(Profile profile) {
        profiles.add(profile);
        profile.setUser(this);
    }

    /**
     * Remove Profile
     * @param profile the profile to be removed
     */
    public void removeProfile(Profile profile) {
        profiles.remove(profile);
        profile.setUser( null );
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password);
    }
}
