package com.anuj.CineRec.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    private String username;
    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles roles;



}
