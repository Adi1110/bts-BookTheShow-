package com.codeOlogy.booktheshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.exceptionHandler.MovieException;
import com.codeOlogy.booktheshow.exceptionHandler.MovieNotFoundException;
import com.codeOlogy.booktheshow.services.MovieService;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService moviesService;

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        try {
            List<Movies> movies = moviesService.getAllMovies();
            return ResponseEntity.ok(movies);
        } catch (MovieException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable Long id) {
        try {
            Optional<Movies> movie = moviesService.getMovieById(id);
            return movie.map(ResponseEntity::ok)
                    .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found"));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (MovieException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/create-movies")
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movie) {
        try {
            Movies savedMovie = moviesService.saveMovie(movie);
            return ResponseEntity.ok(savedMovie);
        } catch (MovieException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable Long id, @RequestBody Movies movie) {
        try {
            Movies updatedMovie = moviesService.updateMovie(id, movie);
            return ResponseEntity.ok(updatedMovie);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (MovieException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            moviesService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(404).build();
        } catch (MovieException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(MovieException.class)
    public ResponseEntity<String> handleMovieException(MovieException ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
