package controller;

import model.Field;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.FieldRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fields")
public class FieldController {
    @Autowired
    private FieldRepository fieldRepository;

    @GetMapping
    public String getAllFields(Model model) {
        List<Field> fields = fieldRepository.findAll();
        model.addAttribute("fields", fields);
        return "fields";
    }

    @GetMapping("/{fieldId}")
    public String getFieldById(@PathVariable("fieldId") int fieldId, Model model) {
        Optional<Field> field = fieldRepository.findById(fieldId);

        if (field.isPresent()) {
            model.addAttribute("field", field.get());
            return "field-details";
        } else {
            return "redirect:/fields";
        }
    }

    @GetMapping("/new")
    public String showCreateFieldForm(Model model) {
        Field field = new Field();
        model.addAttribute("field", field);
        return "create-field";
    }

    @PostMapping("/new")
    public String createField(@ModelAttribute("field") Field field) {
        fieldRepository.save(field);
        return "redirect:/fields";
    }

    @GetMapping("/{fieldId}/edit")
    public String showEditFieldForm(@PathVariable("fieldId") int fieldId, Model model) {
        Optional<Field> field = fieldRepository.findById(fieldId);

        if (field.isPresent()) {
            model.addAttribute("field", field.get());
            return "edit-field";
        } else {
            return "redirect:/fields";
        }
    }

    @PostMapping("/{fieldId}/edit")
    public String editField(@ModelAttribute("field") Field field) {
        fieldRepository.save(field);
        return "redirect:/fields";
    }

    @GetMapping("/{fieldId}/delete")
    public String deleteField(@PathVariable("fieldId") int fieldId) {
        fieldRepository.deleteById(fieldId);
        return "redirect:/fields";
    }
}
