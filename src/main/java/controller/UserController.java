package controller;

import org.springframework.ui.Model;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            return "redirect:/home";
        } else {
            // Failed login
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    /*
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users"; // This should be the name of the view (i.e., the HTML file) you want to render
    }


    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "userId") int userId,
                                               @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(userId);

        user.setUserId(userDetails.getUserId());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        final User updatedEmployee = userRepository.save(user);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "userId") int userId){
        User user = userRepository.findById(userId);

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    */
}
