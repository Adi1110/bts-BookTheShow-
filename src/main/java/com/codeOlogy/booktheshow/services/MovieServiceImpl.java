package com.codeOlogy.booktheshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.exceptionHandler.MovieException;
import com.codeOlogy.booktheshow.exceptionHandler.MovieNotFoundException;
import com.codeOlogy.booktheshow.repository.MoviesRepository;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movies> getAllMovies() {
        // TODO Auto-generated method stub
        try {
            return moviesRepository.findAll();
        } catch (Exception e) {
            throw new MovieException("Error fetching all movies", e);
        }
    }

    @Override
    public Optional<Movies> getMovieById(Long id) {
        // TODO Auto-generated method stub
        try {
            return moviesRepository.findById(id);
        } catch (Exception e) {
            throw new MovieException("Error fetching movie by ID: " + id, e);
        }
    }

    @Override
    public Movies saveMovie(Movies movie) {
        // TODO Auto-generated method stub
        try {
            return moviesRepository.save(movie);
        } catch (Exception e) {
            throw new MovieException("Error saving movie", e);
        }
    }

    @Override
    public Movies updateMovie(Long id, Movies movie) {
        // TODO Auto-generated method stub
        try {
            Optional<Movies> existingMovie = moviesRepository.findById(id);
            if (existingMovie.isPresent()) {
                Movies updatedMovie = existingMovie.get();
                updatedMovie.setMovieTitle(movie.getMovieTitle());
                updatedMovie.setMovieDescription(movie.getMovieDescription());
                updatedMovie.setCities(movie.getCities());
                updatedMovie.setGenre(movie.getGenre());
                updatedMovie.setLanguage(movie.getLanguage());
                updatedMovie.setReleaseDate(movie.getReleaseDate());
                updatedMovie.setDuration(movie.getDuration());
                updatedMovie.setShows(movie.getShows());
                return moviesRepository.save(updatedMovie);
            } else {
                throw new MovieNotFoundException("Movie with ID " + id + " not found");
            }
        } catch (MovieNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new MovieException("Error updating movie", e);
        }
    }

    @Override
    public void deleteMovie(Long id) {
        // TODO Auto-generated method stub
        try {
            if (moviesRepository.existsById(id)) {
                moviesRepository.deleteById(id);
            } else {
                throw new MovieNotFoundException("Movie with ID " + id + " not found");
            }
        } catch (MovieNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new MovieException("Error deleting movie", e);
        }
    }

}
