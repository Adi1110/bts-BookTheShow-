package com.codeOlogy.booktheshow.helper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codeOlogy.booktheshow.entity.City;
import com.codeOlogy.booktheshow.entity.Movies;
import com.codeOlogy.booktheshow.entity.Shows;
import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;
import com.codeOlogy.booktheshow.services.MovieService;

@Component
public class DataLoader implements CommandLineRunner {

        @Autowired
        private MovieService movieService;

        @Override
        public void run(String... args) throws Exception {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Shows show1 = new Shows();
                show1.setShowName("Morning Show");
                show1.setDescription("9 AM to 12 PM");

                Shows show2 = new Shows();
                show2.setShowName("Evening Show");
                show2.setDescription("5 PM to 8 PM");

                show1 = movieService.saveShow(show1);
                show2 = movieService.saveShow(show2);

                City city1 = new City();
                city1.setName("Mumbai");
                City city2 = new City();
                city2.setName("Delhi");

                city1 = movieService.saveCity(city1);
                city2 = movieService.saveCity(city2);

                Movies movie1 = new Movies();
                movie1.setMovieTitle("Dangal");
                movie1.setMovieDescription("The story of a former wrestler and his two wrestler daughters.");
                movie1.setGenre(Genre.DRAMA);
                movie1.setLanguage(Language.HINDI);
                movie1.setReleaseDate(sdf.parse("2016-12-23"));
                movie1.setDuration("2 hours 41 minutes");
                movie1.setShows(show1);
                movie1.setCities(new HashSet<>(Arrays.asList(city1, city2)));

                Movies movie2 = new Movies();
                movie2.setMovieTitle("PK");
                movie2.setMovieDescription("A stranger in the city asks questions no one has asked before.");
                movie2.setGenre(Genre.COMEDY);
                movie2.setLanguage(Language.HINDI);
                movie2.setReleaseDate(sdf.parse("2014-12-19"));
                movie2.setDuration("2 hours 33 minutes");
                movie2.setShows(show2);
                movie2.setCities(new HashSet<>(Arrays.asList(city1)));

                // Add more movies as needed

                movieService.saveMovies(Arrays.asList(movie1, movie2));
                movieService.printMoviesWithCityNames(); // To print movies with city names
        }
}
