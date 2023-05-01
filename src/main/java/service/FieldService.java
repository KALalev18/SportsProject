package service;

import model.Field;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FieldRepository;
import repository.OrderRepository;

import java.util.List;
@Service
public class FieldService {
    @Autowired
    private FieldRepository fieldRepository;
    public Field saveField(Field field)
    {
        return fieldRepository.save(field);
    }

    public void deleteField(Field field)
    {
        fieldRepository.delete(field);
    }

    public Field showFieldById(int id)
    {
        return fieldRepository.findById(id).orElse(null);
    }

    public List<Field> showFields()
    {
        return fieldRepository.findAll();
    }

    public Field findByField(String field)
    {
        return fieldRepository.findByField(field);
    }
    public Field getFieldByStartedWorkingTimeAndFinishedWorkingTime(String startedTime, String finishedTime){
        return fieldRepository.getFieldByStartedWorkingTimeAndFinishedWorkingTime(startedTime, finishedTime);
    }
}
