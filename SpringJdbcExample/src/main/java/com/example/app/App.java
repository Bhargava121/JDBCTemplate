package com.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.User;
import com.example.DAO.*;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);

        User user = new User();
        user.setName("Bhargava");
        user.setEmail("john@example.com");

        userDAO.getAllUsers().forEach(u ->
            System.out.println(u.getId() + " - " + u.getName() + " - " + u.getEmail())
        );
    }
}


