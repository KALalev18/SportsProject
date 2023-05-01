package service;

import model.Construction;
import model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConstructionRepository;
import repository.FieldRepository;

import java.util.List;
@Service
public class ConstructionService {
    @Autowired
    private ConstructionRepository constructionRepository;
    public Construction saveConstruction(Construction construction)
    {
        return constructionRepository.save(construction);
    }

    public void deleteConstruction(Construction construction)
    {
        constructionRepository.delete(construction);
    }

    public Construction showConstructionById(int id)
    {
        return constructionRepository.findById(id).orElse(null);
    }

    public List<Construction> showConstructions()
    {
        return constructionRepository.findAll();
    }

    public Construction findByConstruction(String construction)
    {
        return constructionRepository.findByConstruction(construction);
    }
}
