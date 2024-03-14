package com.codeOlogy.booktheshow.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.Shows;
import com.codeOlogy.booktheshow.repository.ShowsRepository;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@Service
public class MovieService {

    @Autowired
    private ShowsRepository showRepository;

    public List<Shows> searchShows(String movieName, String city, LocalDate date, String time) {
        // Retrieve all shows from the database
        List<Shows> allShows = showRepository.findAll();

        // Use Stream API to filter shows based on the provided criteria
        return allShows.stream()
                .filter(show -> movieName == null || show.getMovies().stream()
                        .anyMatch(movie -> movie.getMovieTitle().equalsIgnoreCase(movieName)))
                .filter(show -> time == null || show.getShowTime().equalsIgnoreCase(time))
                .filter(show -> date == null || show.getShowDate().isEqual(date))
                .collect(Collectors.toList());
    }
}
