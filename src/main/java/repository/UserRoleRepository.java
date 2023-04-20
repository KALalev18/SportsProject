package repository;

import model.Construction;
import model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole getUserRoleByRoleId(int roleId);
}
