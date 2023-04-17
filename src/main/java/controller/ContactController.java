package controller;

import model.Contact;
import model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.ContactRepository;
import repository.FieldRepository;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public String index(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts/index";
    }

    @GetMapping("/contacts/{contactId}")
    public String get(@PathVariable int contactId, Model model) {

        contactRepository.findById(contactId).ifPresent(item -> model.addAttribute("item", item));
        return "contacts/details";
    }

    @GetMapping("/contacts/add")
    public String add(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contacts/add";
    }

    @GetMapping("/contacts/edit/{contactId}")
    public String edit(@PathVariable int contactId, Model model)
    {
        model.addAttribute("contactId", contactRepository.findById(contactId));
        return "contacts/edit";
    }

    @RequestMapping(value = "/contacts/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("contact") Contact contact, Model model) {
        model.addAttribute("item", contact);
        contactRepository.save(contact);
        return new ModelAndView("redirect:/contacts");
    }

    @GetMapping("/contacts/delete/{contactId}")
    public ModelAndView delete(@PathVariable int contactId, Model model) throws ChangeSetPersister.NotFoundException {
        Contact contact = contactRepository.findById(contactId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        contactRepository.delete(contact);
        return new ModelAndView("redirect:/contacts");
    }
}
