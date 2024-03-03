package com.codeOlogy.booktheshow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.User;
import com.codeOlogy.booktheshow.repository.UserRepository;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Retrieve the user from the database based on the provided username
		User user =  userRepo.findByemail(username).orElseThrow(() -> new RuntimeException("user not found!!"));

		return user;
	}
}
