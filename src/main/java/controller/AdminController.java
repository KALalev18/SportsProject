package controller;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Admin> admins = adminRepository.findAll();
        model.addAttribute("admins", admins);
        return "index";
    }

    @GetMapping("/create-admin")
    public String createAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "create-admin";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@ModelAttribute Admin admin) {
        adminRepository.save(admin);
        return "redirect:/";
    }

    @GetMapping("/update-admin/{adminId}")
    public String updateAdminForm(@PathVariable("adminId") int adminId, Model model) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (((Optional<?>) adminOptional).isPresent()) {
            Admin admin = adminOptional.get();
            model.addAttribute("admin", admin);
            return "update-admin";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update-admin")
    public String updateAdmin(@ModelAttribute Admin admin) {
        adminRepository.save(admin);
        return "redirect:/";
    }

    @PostMapping("/delete-admin")
    public String deleteAdmin(@RequestParam("adminId") int adminId) {
        adminRepository.deleteById(adminId);
        return "redirect:/";
    }
}
