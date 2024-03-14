package com.codeOlogy.booktheshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.entity.Shows;

/**
 * @author Aditya Ranjan
 *         Youtube : @Code_O_logy
 *         Website : blogsnax.com
 */

public interface ShowsRepository extends JpaRepository<Shows, Long> {
    public Optional<Shows> findById(Long id);
}
