package com.codeOlogy.booktheshow.entity;

import com.codeOlogy.booktheshow.enums.SeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private String seatType;

    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "shows_id") // Assuming the foreign key column name is shows_id
    private Shows shows;

    private double price;
}
