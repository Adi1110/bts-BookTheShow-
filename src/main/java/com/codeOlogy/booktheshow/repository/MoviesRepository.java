package com.codeOlogy.booktheshow.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.entity.Movies;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    public Optional<Movies> findById(Long id);

    public List<Movies> findAll();

    public Optional<Movies> findByMovieTitleAndReleaseDate(String movieTitle, Date releaseDate);
}
