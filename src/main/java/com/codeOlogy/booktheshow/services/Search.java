package com.codeOlogy.booktheshow.services;

import java.util.List;

import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.enums.Genre;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface Search {

    public List<Movies> searchMoviesByNames(String name);

    public List<Movies> searchMoviesByGenre(Genre genre);

    public List<Movies> searchMoviesByLanguage(String language);

    // public List<Movies> searchMoviesByDate(Date releaseDate);
}
