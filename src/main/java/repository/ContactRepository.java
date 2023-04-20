package repository;

import model.Contact;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact getContactByFirstNameAndLastName(String firstName, String lastName);
}
