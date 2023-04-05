package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Constructions")
public class Construction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestId", columnDefinition = "int", nullable = false)
    private int requestId;
    @Column(name = "firstName", columnDefinition = "nvarchar(100)", nullable = false)
    private String firstName;
    @Column(name = "lastName", columnDefinition = "nvarchar(100)", nullable = false)
    private String lastName;
    @Column(name = "phoneNumber", columnDefinition = "nvarchar(100)", nullable = true)
    private String phoneNumber;
    @Column(name = "description", columnDefinition = "nvarchar(1000)", nullable = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "userId")
    @Column(name = "userId", columnDefinition = "int", nullable = false)
    private User userId;

    public Construction(int requestId, String firstName, String lastName, String phoneNumber, String description, User userId) {
        this.requestId = requestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.userId = userId;
    }

    public Construction() {

    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Construction that = (Construction) o;
        return requestId == that.requestId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, firstName, lastName, phoneNumber, description, userId);
    }

    @Override
    public String toString() {
        return "Construction{" +
                "requestId=" + requestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
