package controller;

import dto.AdminDto;
import dto.UserDto;
import jakarta.validation.Valid;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRepository;
import service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("/users/register")
    public String register(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "users/register";
    }

    @PostMapping("/users/register")
    public ModelAndView register(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) {

        try {
            if (bindingResult.hasErrors()) {
                return new ModelAndView("users/register", "user", userDto);
            }
            User registered = userService.registerNewUser(userDto);

        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView modelAndView = new ModelAndView("users/email", "user", userDto);
            modelAndView.addObject("message", "There was a problem with your registration");
            return modelAndView;
        } catch (final RuntimeException ex) {
            return new ModelAndView("users/register", "user", userDto);
        }
    }

    @GetMapping("/users/{userId}")
    public String get(@PathVariable int userId, Model model) {

        userRepository.findById(userId).ifPresent(item -> model.addAttribute("item", item));
        return "users/details";
    }

    @GetMapping("/users/add")
    public String add(Model model) {
        AdminDto adminDto = new AdminDto();
        model.addAttribute("user", adminDto);
        return "users/add";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("user") AdminDto user, Model model) {
        User registered = userService.registerUserAsAdmin(user);

        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/users/edit/{userId}")
    public String edit(@PathVariable int userId, Model model)
    {
        model.addAttribute("user", userRepository.findById(userId));
        return "users/edit";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("item", user);
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/users/delete/{userId}")
    public ModelAndView delete(@PathVariable int userId, Model model) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        userRepository.delete(user);
        return new ModelAndView("redirect:/users");
    }
}
