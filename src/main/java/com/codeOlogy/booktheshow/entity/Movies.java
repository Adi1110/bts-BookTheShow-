package com.codeOlogy.booktheshow.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.codeOlogy.booktheshow.enums.Genre;
import com.codeOlogy.booktheshow.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "movies")
public class Movies {

    public Movies(String string, String string2, Genre drama, Language hindi, Date date, String string3, Shows show1,
            HashSet hashSet) {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;
    private String movieDescription;

    @ManyToMany
    @JoinTable(name = "movie_city", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<City> cities = new HashSet<>();

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

}
