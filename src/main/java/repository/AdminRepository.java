package repository;

import model.Admin;
import model.Construction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByAdmin(String admin);
}
