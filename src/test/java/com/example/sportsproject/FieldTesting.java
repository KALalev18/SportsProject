package com.example.sportsproject;

import model.Field;
import model.Order;
import model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.FieldRepository;
import repository.UserRepository;
import view.SportsProjectApplication;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SportsProjectApplication.class)
public class FieldTesting {
    @Autowired
    private FieldRepository fieldRepository;
    @Test
    public void testField(){
        Field field = new Field();
        field.getFieldLocation("Pomorie");
        field.getStartedWorkingTime("10:00");
        field.getFinishedWorkingTime("18:00");
        field.getPriceByHour(25);
        fieldRepository.save(field);
    }

    @Test
    public void saveFieldWithTesting()
    {
        Field field = new Field();
        field.setFieldLocation(Integer.parseInt("Burgas"));
        DataIntegrityViolationException dataIntegrityViolationExceptionxception = assertThrows(DataIntegrityViolationException.class,()->{
            fieldRepository.save(field);
        },"Thrown Exception save() saving the user");
        System.out.println(dataIntegrityViolationExceptionxception.getMessage());
    }
}
