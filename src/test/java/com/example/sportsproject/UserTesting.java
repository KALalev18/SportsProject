package com.example.sportsproject;

import model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.UserRepository;
import view.SportsProjectApplication;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SportsProjectApplication.class)
public class UserTesting {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testUser(){
        User user=new User();
        user.setFirstName("Kristian");
        user.setLastName("Lalev");
        user.setEmail("kril1@gmail.com");
        user.setPassword("1oihJHBD_");
        userRepository.save(user);
    }

    @Test
    public void saveUserWithTesting()
    {
        User user=new User();
        user.setLastName("Georgiev");
        DataIntegrityViolationException dataIntegrityViolationExceptionxception = assertThrows(DataIntegrityViolationException.class,()->{
            userRepository.save(user);
        },"Thrown Exception save() saving the user");
        System.out.println(dataIntegrityViolationExceptionxception.getMessage());
    }
}

