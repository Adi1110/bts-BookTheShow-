package com.codeOlogy.booktheshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.booktheshow.entity.City;
import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;
import com.codeOlogy.booktheshow.repository.CityRepository;
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

    public SearchController(SearchImpl searchService) {
        this.searchService = searchService;
    }

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/moviesByName")
    public List<Movies> searchMoviesByName(@RequestParam String name) {
        return searchService.searchMoviesByNames(name);
    }

    @GetMapping("/moviesByGenre")
    public List<Movies> searchMoviesByGenre(@RequestParam String genre) {
        Genre genreEnum;
        try {
            genreEnum = Genre.valueOf(genre.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid genre: " + genre);
        }
        return searchService.searchMoviesByGenre(genreEnum);
    }

    @GetMapping("/moviesByLanguage")
    public List<Movies> searchMoviesByLanguage(@RequestParam String language) {
        Language languageEnum;
        try {
            languageEnum = Language.valueOf(language.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid language: " + language);
        }
        return searchService.searchMoviesByLanguage(languageEnum);
    }

    @GetMapping("/moviesByCity")
    public List<Movies> searchMoviesByCity(@RequestParam String city) {
        Optional<City> cityOptional = cityRepository.findByNameIgnoreCase(city);
        if (cityOptional.isPresent()) {
            return searchService.searchMoviesByCity(cityOptional.get());
        } else {
            throw new RuntimeException("City not found");
        }
    }
}
