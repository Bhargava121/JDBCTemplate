package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.DAO.UserDAO;
import com.example.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userDAOImpl")
    private UserDAO userDAO;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
    	return userDAO.getUserById(id);
    }
    
    @PostMapping("/save") 
    public String addUser(@RequestBody User user) {
        userDAO.save(user);
        return "Saved";
    }

}