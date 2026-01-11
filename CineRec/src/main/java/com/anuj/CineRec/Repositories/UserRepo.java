package com.anuj.CineRec.Repositories;

import com.anuj.CineRec.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,String> {


    Optional<Users> findByUsername(String name);

    boolean existsByUsername(String s);
}
