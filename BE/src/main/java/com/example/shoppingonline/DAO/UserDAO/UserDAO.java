package com.example.shoppingonline.DAO.UserDAO;

import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.User;

import java.util.List;

public interface UserDAO {
	User login(String username, String password);
}