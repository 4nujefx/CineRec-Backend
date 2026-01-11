package com.anuj.CineRec.Services;

import com.anuj.CineRec.Entity.Roles;
import com.anuj.CineRec.Entity.Users;
import com.anuj.CineRec.Repositories.GenreRepo;
import com.anuj.CineRec.Repositories.RoleRepo;
import com.anuj.CineRec.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String addUser(Users user){



        Boolean exists= userRepo.existsByUsername(user.getUsername());

        if(exists){
            return "UserName is unavailable";
        }
        else {
            Roles userRole = roleRepo.findByRole("user")
                    .orElseThrow(() -> new RuntimeException("USER role not found"));

            user.setRoles(userRole);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        }
        return "User Signed Up";

    }









}

