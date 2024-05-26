package com.codeOlogy.booktheshow.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.City;
import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;
import com.codeOlogy.booktheshow.repository.MoviesRepository;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@Service
public class SearchImpl implements Search {

    private final MoviesRepository moviesRepository;

    @Autowired
    public SearchImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> searchMoviesByNames(String name) {

        // Fetch all movies from the repository
        List<Movies> allMovies = moviesRepository.findAll();

        // Filter the movies by the provided name and return the list
        return allMovies.stream()
                .filter(movie -> movie.getMovieTitle().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Movies> searchMoviesByGenre(Genre genre) {

        // Fetch all movies from the repository
        List<Movies> allMovies = moviesRepository.findAll();

        // Filter the movies by the provided genre and return the list
        return allMovies.stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public List<Movies> searchMoviesByLanguage(Language language) {

        // Fetch all movies from the repository
        List<Movies> allMovies = moviesRepository.findAll();

        // Filter the movies by the provided language and return the list
        return allMovies.stream()
                .filter(movie -> movie.getLanguage().equals(language))
                .collect(Collectors.toList());
    }

    // public List<Movies> searchMoviesByDate(Date releaseDate) {

    // }

    public List<Movies> searchMoviesByCity(City city) {

        // Fetch all movies from the repository
        List<Movies> allMovies = moviesRepository.findAll();

        // Filter the movies by the provided city and return the list
        return allMovies.stream()
                .filter(movie -> movie.getCities().contains(city))
                .collect(Collectors.toList());
    }
}
