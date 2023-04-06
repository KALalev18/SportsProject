package controller;

import org.springframework.ui.Model;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users"; // This should be the name of the view (i.e., the HTML file) you want to render
    }

    /*
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
