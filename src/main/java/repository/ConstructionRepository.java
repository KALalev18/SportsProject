package repository;

import model.Construction;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstructionRepository extends JpaRepository<Construction, Integer> {
}
