package service;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdminRepository;
import repository.FieldRepository;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public Admin saveAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Admin admin)
    {
        adminRepository.delete(admin);
    }

    public Admin showAdminById(int id)
    {
        return adminRepository.findById(id).orElse(null);
    }

    public List<Admin> showAdmins()
    {
        return adminRepository.findAll();
    }

    public Admin findByAdmin(String admin)
    {
        return adminRepository.findByAdmin(admin);
    }
}
