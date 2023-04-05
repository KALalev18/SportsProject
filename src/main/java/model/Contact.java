package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId", columnDefinition = "int", nullable = false)
    private int contactId;
    @Column(name = "firstName", columnDefinition = "nvarchar(100)", nullable = false)
    private String firstName;
    @Column(name = "lastName", columnDefinition = "nvarchar(100)", nullable = false)
    private String lastName;
    @Column(name = "phoneNumber", columnDefinition = "nvarchar(100)", nullable = true)
    private String phoneNumber;
    @Column(name = "subject", columnDefinition = "nvarchar(1000)", nullable = true)
    private String subject;
    @ManyToOne
    @JoinColumn(name = "userId")
    @Column(name = "userId", columnDefinition = "int", nullable = false)
    private User userId;

    public Contact(int contactId, String firstName, String lastName, String phoneNumber, String subject, User userId) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.subject = subject;
        this.userId = userId;
    }

    public Contact() {

    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        Contact contact = (Contact) o;
        return contactId == contact.contactId && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(subject, contact.subject) && Objects.equals(userId, contact.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, phoneNumber, subject, userId);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", subject='" + subject + '\'' +
                ", userId=" + userId +
                '}';
    }
}
