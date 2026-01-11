package com.anuj.CineRec.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String role;

    @OneToMany(mappedBy = "roles" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Users> users;

}
