package com.anuj.CineRec.Controllers;

import com.anuj.CineRec.Entity.Movies;
import com.anuj.CineRec.Services.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movies")
public class MoviesController {

@Autowired
MoviesServices moviesServices;

@GetMapping("/{Genre_Name}")
public ResponseEntity<List<Movies>> GetMoviesByGenre(@PathVariable String Genre_Name){

    return ResponseEntity.ok().body(moviesServices.MoviesByGenre(Genre_Name));

      }
 @PostMapping("/add/{Genre_Name}")
 public ResponseEntity<String> addMovies(@PathVariable String Genre_Name, @RequestBody List<Movies> movies)    {

    return ResponseEntity.ok().body(moviesServices.saveMovies(Genre_Name, movies));

 }

 @GetMapping("/AllMovies")
 public ResponseEntity<List<Movies>> showAllMovies(){

    return ResponseEntity.ok().body(moviesServices.showAllMovies());

 }

}
