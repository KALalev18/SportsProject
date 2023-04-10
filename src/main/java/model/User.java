package model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", columnDefinition = "int", nullable = false)
    private int userId;
    @Column(name = "firstName", columnDefinition = "nvarchar(100)", nullable = false)
    private String firstName;
    @Column(name = "lastName", columnDefinition = "nvarchar(100)", nullable = false)
    private String lastName;
    @Column(name = "email", columnDefinition = "nvarchar(100)", nullable = false)
    private String email;
    @Column(name = "password", columnDefinition = "nvarchar(100)", nullable = false)
    private String password;
    @Column(name = "isAdmin", columnDefinition = "bit", nullable = false)
    private boolean isAdmin;



    public User(int userId, String firstName, String lastName, String email, String password, boolean isAdmin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {

    }

    public User(int id, String name, String email) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
