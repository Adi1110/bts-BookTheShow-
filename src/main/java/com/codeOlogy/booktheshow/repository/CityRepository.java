package com.codeOlogy.booktheshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.entity.City;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByNameIgnoreCase(String name);
}
