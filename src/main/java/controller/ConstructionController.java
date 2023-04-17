package controller;

import model.Construction;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.ConstructionRepository;
import repository.ContactRepository;

@Controller
public class ConstructionController {
    @Autowired
    private ConstructionRepository constructionRepository;

    @GetMapping("/constructions")
    public String index(Model model) {
        model.addAttribute("constructions", constructionRepository.findAll());
        return "constructions/index";
    }

    @GetMapping("/constructions/{constructionId}")
    public String get(@PathVariable int constructionId, Model model) {

        constructionRepository.findById(constructionId).ifPresent(item -> model.addAttribute("item", item));
        return "constructions/details";
    }

    @GetMapping("/constructions/add")
    public String add(Model model) {
        Construction construction = new Construction();
        model.addAttribute("construction", construction);
        return "constructions/add";
    }

    @GetMapping("/constructions/edit/{constructionId}")
    public String edit(@PathVariable int constructionId, Model model)
    {
        model.addAttribute("constructionId", constructionRepository.findById(constructionId));
        return "constructions/edit";
    }

    @RequestMapping(value = "/constructions/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("construction") Construction construction, Model model) {
        model.addAttribute("item", construction);
        constructionRepository.save(construction);
        return new ModelAndView("redirect:/constructions");
    }

    @GetMapping("/contacts/delete/{contactId}")
    public ModelAndView delete(@PathVariable int constructionId, Model model) throws ChangeSetPersister.NotFoundException {
        Construction construction = constructionRepository.findById(constructionId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        constructionRepository.delete(construction);
        return new ModelAndView("redirect:/constructions");
    }
}
