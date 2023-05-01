package controller;

import jakarta.validation.Valid;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.ContactRepository;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public String getAllContacts(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "contact-list";
    }

    @GetMapping("/{contactId}")
    public String getContactById(@PathVariable("id") int contactId, Model model) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID: " + contactId));
        model.addAttribute("contact", contact);
        return "contact-details";
    }

    @GetMapping("/new")
    public String createContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/new")
    public String createContact(@Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "contact-form";
        }
        contactRepository.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/{contactId}/edit")
    public String updateContactForm(@PathVariable("contactId") int contactId, Model model) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID: " + contactId));
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/{contactId}/edit")
    public String updateContact(@PathVariable("contactId") int contactId, @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "contact-form";
        }
        contactRepository.save(contact);
        return "redirect:/contacts/" + contactId;
    }

    @GetMapping("/{contactId}/delete")
    public String deleteContact(@PathVariable("id") int contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID: " + contactId));
        contactRepository.delete(contact);
        return "redirect:/contacts";
    }
}
