package controller;

import model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/create-user")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/update-user/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);
        if (((Optional<?>) userOptional).isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "update-user";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") int userId) {
        userRepository.deleteById(userId);
        return "redirect:/";
    }
}
