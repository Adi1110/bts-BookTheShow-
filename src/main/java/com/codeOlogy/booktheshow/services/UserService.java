package com.codeOlogy.booktheshow.services;

import java.util.List;

import com.codeOlogy.booktheshow.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */



public interface UserService {

    public  List<User> getUsers();
    public User createUser(User user);
    public User getUserById(Long id);
    // public User updateUser(User user);
    // public void deleteUser(Long id);
}
