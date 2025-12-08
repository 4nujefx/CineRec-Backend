package com.anuj.CineRec.Repositories;

import com.anuj.CineRec.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepo extends JpaRepository<Genre, Long> {

    Optional<Genre> findByName(String name);

    boolean existsByName(String name);
}
