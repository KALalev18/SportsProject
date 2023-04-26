package service;

import dto.AdminDto;
import dto.UserDto;
import model.User;

public interface UserServiceInterface {
    User registerNewUser(UserDto userDto);
    User registerUserAsAdmin(AdminDto adminDto);
}
