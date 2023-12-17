package com.example.shoppingonline.DAO.CustomerDAO;

import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.Customer;

import java.util.List;

public interface CustomerDAO {

	List<Customer> getAllCustomers();
	Customer getCustomer(int customerId);
	boolean deleteCustomer(int customerId);
	Customer editCustomer(int customerId, Customer newCustomer);
	Customer register(Account acc);

}