package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.UserDAO.UserDAO;
import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userDAO.login(username, password);
    }
}