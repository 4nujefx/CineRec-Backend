package com.anuj.CineRec.Services;

import com.anuj.CineRec.Entity.Genre;
import com.anuj.CineRec.Entity.Movies;
import com.anuj.CineRec.Repositories.GenreRepo;
import com.anuj.CineRec.Repositories.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MoviesServices {

    @Autowired
    MoviesRepo moviesRepo;
    @Autowired
    GenreRepo genreRepo;

    public List<Movies> MoviesByGenre(String genre_name){

        return moviesRepo.findAllByGenre_Name(genre_name);

    }

    public String saveMovies(String genreName , List<Movies> movies ){

        Genre genre = genreRepo.findByName(genreName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found"));


        for(Movies m : movies){

        boolean exists = moviesRepo.existsByTitle(m.getTitle());

        if(!exists){
            m.setGenre(genre);
            moviesRepo.save(m);
        }


       }

        return "movies_added";

    }

    public List<Movies> showAllMovies(){

        return moviesRepo.findAll();

    }

}
