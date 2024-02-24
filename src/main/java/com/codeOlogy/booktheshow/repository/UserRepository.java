package com.codeOlogy.booktheshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.model.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */


public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByemail(String email);
}