package com.codeOlogy.booktheshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;
import com.codeOlogy.booktheshow.services.SearchImpl;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@RestController
@RequestMapping("/movies/search")
public class SearchController {

    private final SearchImpl searchService;

    @Autowired
    public SearchController(SearchImpl searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/moviesByName")
    public List<Movies> searchMoviesByName(@RequestParam String name) {
        return searchService.searchMoviesByNames(name);
    }

    @GetMapping("/moviesByGenre")
    public List<Movies> searchMoviesByGenre(@RequestParam Genre genre) {
        return searchService.searchMoviesByGenre(genre);
    }

    @GetMapping("/moviesByLanguage")
    public List<Movies> searchMoviesByLanguage(@RequestParam Language language) {
        return searchService.searchMoviesByLanguage(language);
    }

    // @GetMapping("/movies/search")
    // public List<Movie> searchMovies(@RequestParam String searchTerm) {
    // return movieService.searchMovies(searchTerm);
    // }
}
