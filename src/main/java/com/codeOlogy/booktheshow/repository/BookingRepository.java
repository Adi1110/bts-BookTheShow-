package com.codeOlogy.booktheshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.entity.Bookings;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface BookingRepository extends JpaRepository<Bookings, Long> {

}
