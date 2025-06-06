package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.DAO.UserDAO;
import com.example.model.User;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userDAO.getAllUsers());
        return "user-form";
    }

}