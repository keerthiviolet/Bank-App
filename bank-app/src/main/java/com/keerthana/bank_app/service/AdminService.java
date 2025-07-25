package com.keerthana.bank_app.service;

import com.keerthana.bank_app.model.Admin;
import com.keerthana.bank_app.model.User;
import com.keerthana.bank_app.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id){
        return adminRepository.getReferenceById(id);
    }
    public boolean adminExistById(Long id) {
        return adminRepository.existsById(id);
    }

    public boolean validateAdminCredentials(Long id, String adminPassword) {
        return (getAdminById(id).getAdminPassword()).equals(adminPassword);
    }

    public void updateAdminPassword(Long adminId, String newAdminPassword) {
        adminRepository.getReferenceById(adminId).setAdminPassword(newAdminPassword);
    }
}
