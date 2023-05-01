package repository;

import model.Construction;
import model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole getUserRoleByRoleId(int roleId);
    @Query(value= "UPDATE UserRoles SET RoleName=:roleName WHERE RoleId=:roleId")
    void update(String roleName, int roleId);
}
