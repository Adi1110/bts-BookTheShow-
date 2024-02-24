package com.codeOlogy.booktheshow.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.booktheshow.model.User;
import com.codeOlogy.booktheshow.services.UserServiceImpl;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@RestController
@RequestMapping("/bts")
public class UserController {
    
    @Autowired
    private UserServiceImpl service;
    
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        System.out.println("getting users.......");
        return this.service.getUsers();
    }


    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }
    

}
