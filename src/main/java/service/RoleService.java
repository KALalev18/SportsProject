package service;

import model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<UserRole> getAllRoles();
    UserRole getRoleById(int roleId);
    void updateRole(UserRole userRole);
    void deleteRoleById(int roleId);
}
