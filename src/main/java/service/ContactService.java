package service;

import model.Contact;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ContactRepository;
import repository.OrderRepository;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public Contact saveContact(Contact contact)
    {
        return contactRepository.save(contact);
    }

    public void deleteContact(Contact contact)
    {
        contactRepository.delete(contact);
    }

    public Contact showContactById(int id)
    {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> showContacts()
    {
        return contactRepository.findAll();
    }

    public Contact findByContact(String contact)
    {
        return contactRepository.findByContact(contact);
    }
}
