package com.codeOlogy.booktheshow.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "movies", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "movieTitle", "releaseDate" }) })
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;
    private String movieDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_city", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<City> cities = new HashSet<>();

    @Column(name = "cities")
    private String cityNames;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "shows_id") // Assuming the foreign key column name is shows_id
    private Shows shows;

    @PrePersist
    @PreUpdate
    private void updateCityNames() {
        this.cityNames = cities.stream()
                .map(City::getName)
                .collect(Collectors.joining(", "));
    }

    // equals and hashCode methods based on movieTitle and releaseDate
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Movies movie = (Movies) o;

        if (!movieTitle.equals(movie.movieTitle))
            return false;
        return releaseDate.equals(movie.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = movieTitle.hashCode();
        result = 31 * result + releaseDate.hashCode();
        return result;
    }

    public String getCityNames() {
        return cities.stream()
                .map(City::getName)
                .collect(Collectors.joining(", "));
    }
}
