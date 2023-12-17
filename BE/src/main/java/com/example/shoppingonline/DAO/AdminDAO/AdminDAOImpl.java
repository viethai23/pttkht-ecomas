package com.example.shoppingonline.DAO.AdminDAO;

import com.example.shoppingonline.Model.User.Admin;

import com.example.shoppingonline.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean deleteAdmin(int adminId) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            adminRepository.delete(admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean editAdmin(int adminId, Admin updatedAdmin) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            Admin existingAdmin = adminOptional.get();
            existingAdmin.setEmail(updatedAdmin.getEmail());
            existingAdmin.setRole(updatedAdmin.getRole());
            adminRepository.save(existingAdmin);
            return true;
        }
        return false;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}