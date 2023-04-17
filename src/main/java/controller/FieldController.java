package controller;

import model.Field;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.FieldRepository;

@Controller
public class FieldController {
    @Autowired
    private FieldRepository fieldRepository;

    @GetMapping("/fields")
    public String index(Model model) {
        model.addAttribute("fields", fieldRepository.findAll());
        return "fields/index";
    }

    @GetMapping("/fields/{fieldId}")
    public String get(@PathVariable int fieldId, Model model) {

        fieldRepository.findById(fieldId).ifPresent(item -> model.addAttribute("item", item));
        return "fields/details";
    }

    @GetMapping("/fields/add")
    public String add(Model model) {
        Field field = new Field();
        model.addAttribute("field", field);
        return "fields/add";
    }

    @GetMapping("/fields/edit/{fieldId}")
    public String edit(@PathVariable int fieldId, Model model)
    {
        model.addAttribute("fieldId", fieldRepository.findById(fieldId));
        return "fields/edit";
    }

    @RequestMapping(value = "/fields/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("field") Field field, Model model) {
        model.addAttribute("item", field);
        fieldRepository.save(field);
        return new ModelAndView("redirect:/fields");
    }

    @GetMapping("/fields/delete/{fieldId}")
    public ModelAndView delete(@PathVariable int fieldId, Model model) throws ChangeSetPersister.NotFoundException {
        Field field = fieldRepository.findById(fieldId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        fieldRepository.delete(field);
        return new ModelAndView("redirect:/products");
    }
}
