package service;

import model.Admin;
import model.User;
import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import repository.AdminRepository;
import repository.UserRepository;
import repository.UserRoleRepository;

@Controller
public class RoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    public String getRole(UserRole userRole)
    {
        if (Boolean.parseBoolean(userRole.getRoleName(String.valueOf("admin"))))
        {
            System.out.println("admin");
            return "admin";
        }
        else
        {
            System.out.println("user");
            return "user";
        }
    }

    public void updateRole(String roleName, int roleId)
    {
        userRoleRepository.update(roleName, roleId);
    }

    public UserRole saveRole(UserRole userRole)
    {
        return userRoleRepository.save(userRole);
    }

    public void deleteRole(UserRole userRole)
    {
        userRoleRepository.delete(userRole);
    }

    public boolean isAdmin(Admin admin)
    {
        return userRepository.findById(admin.getAdminId())!=null;
    }

    public boolean isUser(User user)
    {
        return adminRepository.findById(user.getUserId())!=null;
    }
}
