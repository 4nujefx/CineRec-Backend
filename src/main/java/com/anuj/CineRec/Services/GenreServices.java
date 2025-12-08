package com.anuj.CineRec.Services;

import com.anuj.CineRec.Entity.Genre;
import com.anuj.CineRec.Repositories.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServices {

    @Autowired
    GenreRepo genreRepo;

public List<Genre> getAllGenres(){

    return genreRepo.findAll();

}

public String addGenre(Genre genre){

    boolean exists = genreRepo.existsByName(genre.getName());
    if(exists){
        return "Genre Already Exists";
    }
    else {
        genreRepo.save(genre);
    }

    return "Genre Added";
}

}
