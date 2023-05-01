package controller;

import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRoleRepository;

@Controller
public class UserRoleController {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/userroles")
    public String index(Model model) {
        model.addAttribute("userroles", userRoleRepository.findAll());
        return "userroles/index";
    }

    @GetMapping("/userroles/{roleId}")
    public String get(@PathVariable int roleId, Model model) {

        userRoleRepository.findById(roleId).ifPresent(item -> model.addAttribute("item", item));
        return "userroles/details";
    }

    @GetMapping("/userroles/add")
    public String add(Model model) {
        UserRole userRole = new UserRole();
        model.addAttribute("userrole", userRole);
        return "userroles/add";
    }

    @GetMapping("/userroles/edit/{roleId}")
    public String edit(@PathVariable int roleId, Model model)
    {
        model.addAttribute("roleId", userRoleRepository.findById(roleId));
        return "userroles/edit";
    }

    @RequestMapping(value = "/userroles/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("userrole") UserRole userRole, Model model) {
        model.addAttribute("item", userRole);
        userRoleRepository.save(userRole);
        return new ModelAndView("redirect:/userroles");
    }

    @GetMapping("/userroles/delete/{roleId}")
    public ModelAndView delete(@PathVariable int roleId, Model model) throws ChangeSetPersister.NotFoundException {
        UserRole userRole = userRoleRepository.findById(roleId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        userRoleRepository.delete(userRole);
        return new ModelAndView("redirect:/products");
    }
}