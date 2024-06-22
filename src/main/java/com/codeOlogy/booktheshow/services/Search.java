package com.codeOlogy.booktheshow.services;

import java.util.List;

import com.codeOlogy.booktheshow.entity.City;
import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface Search {

    public List<Movies> searchMoviesByNames(String name);

    public List<Movies> searchMoviesByGenre(Genre genre);

    public List<Movies> searchMoviesByLanguage(Language language);

    public List<Movies> searchMoviesByCity(City city);
}
