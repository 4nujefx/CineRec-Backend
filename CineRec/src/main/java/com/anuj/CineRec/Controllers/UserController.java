package com.anuj.CineRec.Controllers;


import com.anuj.CineRec.Entity.Users;
import com.anuj.CineRec.Repositories.RoleRepo;
import com.anuj.CineRec.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/USER")
public class UserController {

    @Autowired
    UserServices userServices;


    @PostMapping("/user")
    public ResponseEntity<String> SignUpUser(@RequestBody Users user){

        return ResponseEntity.ok().body(userServices.addUser(user));

    }



}
