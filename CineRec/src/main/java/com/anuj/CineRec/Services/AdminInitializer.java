package com.anuj.CineRec.Services;

import com.anuj.CineRec.Entity.Roles;
import com.anuj.CineRec.Entity.Users;
import com.anuj.CineRec.Repositories.RoleRepo;
import com.anuj.CineRec.Repositories.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminInitializer {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void createAdminOnce() {
        String adminUsername = "admin";

        // Check if admin already exists
        if (userRepository.existsById(adminUsername)) {
            System.out.println("Admin already exists, skipping creation.");
            return; // already created
        }

        // Get ADMIN role from DB
        Roles adminRole = roleRepository.findByRole("ADMIN")
                .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

        // Create admin user
        Users admin = new Users();
        admin.setUsername(adminUsername);
        admin.setPassword(passwordEncoder.encode("admin")); // encrypted
        admin.setRoles(adminRole);

        userRepository.save(admin);

        System.out.println("Admin user created successfully!");
    }
}
