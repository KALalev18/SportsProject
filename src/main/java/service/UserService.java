package service;

import dto.AdminDto;
import dto.UserDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void updateUser(String firstName, String lastName, String email, String password, int roleId, int userId)
    {
        userRepository.update(firstName, lastName, email, password, roleId, userId);
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUser(User user)
    {
        userRepository.delete(user);
    }

    public User showUserById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }
    public User showUserByRoleId(int id)
    {
        return (User) userRepository.findByRoleId(id).orElse(null);
    }

    public List<User> showUsers()
    {
        return userRepository.findAll();
    }

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User findByFirstName(String firstName)
    {
        return userRepository.findByFirstName(firstName);
    }

    public User findByLastName(String lastName)
    {
        return userRepository.findByLastName(lastName);
    }

    public boolean checkEmail(User user)
    {
        return userRepository.emailExists(user.getEmail());
    }

    public boolean checkPassword(User user, User loginUser)
    {
        return user.getPassword().equals(user.getPassword());
    }
}
