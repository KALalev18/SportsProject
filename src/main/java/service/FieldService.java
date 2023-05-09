package service;

import model.Field;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FieldService {
    List<Field> getAllFields();
    Field getFieldById(int fieldId);
    void createField(Field field);
    void updateField(Field field);
    void deleteFieldById(int fieldId);
}
