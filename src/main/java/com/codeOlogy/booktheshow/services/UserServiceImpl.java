package com.codeOlogy.booktheshow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.User;
import com.codeOlogy.booktheshow.repository.UserRepository;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return this.repo.findAll();
    }

    @Override
    public User createUser(User user) {
        // TODO Auto-generated method stub
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
    
}
