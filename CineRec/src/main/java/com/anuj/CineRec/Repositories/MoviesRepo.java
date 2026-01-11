package com.anuj.CineRec.Repositories;

import com.anuj.CineRec.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepo extends JpaRepository<Movies, Long> {
        List<Movies> findAllByGenre_Name(String name);


    boolean existsByTitle(String title);
}
