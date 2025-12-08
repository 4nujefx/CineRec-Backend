package com.anuj.CineRec.Controllers;


import com.anuj.CineRec.Entity.Genre;
import com.anuj.CineRec.Services.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Genre")
public class GenreController {

    @Autowired
    GenreServices genreServices;

    @PostMapping("/addGenre")
    public ResponseEntity<String> addGenre(@RequestBody Genre genre){

        return ResponseEntity.ok().body(genreServices.addGenre(genre));

    }
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres(){

        return ResponseEntity.ok().body(genreServices.getAllGenres());
    }






}
