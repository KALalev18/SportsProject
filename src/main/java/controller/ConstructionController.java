package controller;

import jakarta.validation.Valid;
import model.Construction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.ConstructionRepository;

import java.util.List;

@Controller
@RequestMapping("/constructions")
public class ConstructionController {
    @Autowired
    private ConstructionRepository constructionRepository;

    @GetMapping("/")
    public String getAllConstruction(Model model) {
        List<Construction> constructions = constructionRepository.findAll();
        model.addAttribute("constructions", constructions);
        return "construction-list";
    }

    @GetMapping("/{constructionId}")
    public String getConstructionById(@PathVariable("constructionId") int constructionId, Model model) {
        Construction construction = constructionRepository.findById(constructionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid construction ID: " + constructionId));
        model.addAttribute("construction", construction);
        return "construction-details";
    }

    @GetMapping("/new")
    public String createConstructionForm(Model model) {
        model.addAttribute("construction", new Construction());
        return "construction-form";
    }

    @PostMapping("/new")
    public String createConstruction(@Valid Construction construction, BindingResult result) {
        if (result.hasErrors()) {
            return "construction-form";
        }
        constructionRepository.save(construction);
        return "redirect:/constructions";
    }

    @GetMapping("/{constructionId}/edit")
    public String updateConstructionForm(@PathVariable("constructionId") int constructionId, Model model) {
        Construction construction = constructionRepository.findById(constructionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid construction ID: " + constructionId));
        model.addAttribute("construction", construction);
        return "construction-form";
    }

    @PostMapping("/{constructionId}/edit")
    public String updateConstruction(@PathVariable("constructionId") int constructionId, @Valid Construction construction, BindingResult result) {
        if (result.hasErrors()) {
            return "construction-form";
        }
        constructionRepository.save(construction);
        return "redirect:/constructions/" + constructionId;
    }

    @GetMapping("/{constructionId}/delete")
    public String deleteConstruction(@PathVariable("constructionId") int constructionId) {
        Construction construction = constructionRepository.findById(constructionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid construction ID: " + constructionId));
        constructionRepository.delete(construction);
        return "redirect:/constructions";
    }
}
