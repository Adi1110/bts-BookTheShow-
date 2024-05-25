package com.codeOlogy.booktheshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        for (Movies movie : movies) {
            Optional<Movies> existingMovie = movieRepository.findByMovieTitleAndReleaseDate(
                    movie.getMovieTitle(), movie.getReleaseDate());
            if (existingMovie.isPresent()) {
                // Update existing movie details
                Movies movieToUpdate = existingMovie.get();
                movieToUpdate.setMovieDescription(movie.getMovieDescription());
                movieToUpdate.setGenre(movie.getGenre());
                movieToUpdate.setLanguage(movie.getLanguage());
                movieToUpdate.setDuration(movie.getDuration());
                movieToUpdate.setShows(movie.getShows());
                movieToUpdate.getCities().addAll(movie.getCities());
                movieRepository.save(movieToUpdate);
            } else {
                // Save new movie
                movieRepository.save(movie);
            }
        }
    }

    public Shows saveShow(Shows shows) {
        return showsRepository.save(shows);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public void printMoviesWithCityNames() {
        List<Movies> movies = movieRepository.findAll();
        for (Movies movie : movies) {
            System.out.println("Movie: " + movie.getMovieTitle() + ", Cities: " + movie.getCityNames());
        }
    }
}
