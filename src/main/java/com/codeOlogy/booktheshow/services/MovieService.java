package com.codeOlogy.booktheshow.services;

import java.util.List;
import java.util.Optional;

import com.codeOlogy.booktheshow.entity.Movies;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface MovieService {

    List<Movies> getAllMovies();

    Optional<Movies> getMovieById(Long id);

    Movies saveMovie(Movies movie);

    Movies updateMovie(Long id, Movies movie);

    void deleteMovie(Long id);
}
