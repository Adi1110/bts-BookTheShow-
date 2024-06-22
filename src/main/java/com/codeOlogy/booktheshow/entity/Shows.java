package com.codeOlogy.booktheshow.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "shows")
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String showName;

    // @ManyToMany
    // private Theaters theatreId;

    @OneToMany(mappedBy = "shows")

    private List<Seat> listOfSeats;

    @OneToMany(mappedBy = "shows") // mappedBy should be the name of the property in Movie entity referring to
    @JsonIgnore // JSON serialization annotations to avoid serializing the entire object graph.
                // The @JsonIgnore annotation from the Jackson library can help prevent the
                // infinite loop by ignoring the reverse reference.
    private List<Movies> movies;

    private LocalDate showDate;

    private String description;

    private String startTime;
    private String endTime;
}
