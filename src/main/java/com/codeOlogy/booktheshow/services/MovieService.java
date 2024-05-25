package com.codeOlogy.booktheshow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.City;
import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.entity.Shows;
import com.codeOlogy.booktheshow.repository.CityRepository;
import com.codeOlogy.booktheshow.repository.MoviesRepository;
import com.codeOlogy.booktheshow.repository.ShowsRepository;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@Service
public class MovieService {

    @Autowired
    private MoviesRepository movieRepository;

    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    private CityRepository cityRepository;

    public void saveMovies(List<Movies> movies) {
        movieRepository.saveAll(movies);
    }

    public Shows saveShow(Shows shows) {
        return showsRepository.save(shows);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }
}
