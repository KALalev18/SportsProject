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

    public User registerNewUser(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an existing account with this email address: "
                    + userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoleId(userDto.getRoleId());
        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    public User registerUserAsAdmin(AdminDto adminDto) throws UserAlreadyExistException {
        if (emailExists(adminDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + adminDto.getEmail());
        }
        User user = new User();
        user.setFirstName(adminDto.getFirstName());
        user.setLastName(adminDto.getLastName());
        user.setEmail(adminDto.getEmail());
        user.setPassword(adminDto.getPassword());
        user.setRoleId(adminDto.getRoleId());

        User updatedUser = userRepository.save(user);

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.getUserByEmail(email) != null;
    }
}
