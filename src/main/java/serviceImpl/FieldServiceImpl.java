package serviceImpl;

import model.Field;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FieldRepository;
import repository.OrderRepository;
import service.FieldService;

import java.util.List;
import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldRepository fieldRepository;
    @Override
    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public Field getFieldById(int fieldId) {
        Optional<Field> field = fieldRepository.findById(fieldId);
        return field.orElse(null);
    }

    @Override
    public void createField(Field field) {
        fieldRepository.save(field);
    }

    @Override
    public void updateField(Field field) {
        fieldRepository.save(field);
    }

    @Override
    public void deleteFieldById(int fieldId) {
        fieldRepository.deleteById(fieldId);
    }
}
