package com.example.shoppingonline.DAO.CustomerDAO;

import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.Customer;

import com.example.shoppingonline.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			customerRepository.delete(customerOptional.get());
			return true;
		}
		return false;
	}

	@Override
	public Customer editCustomer(int customerId, Customer newCustomer) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer existingCustomer = customerOptional.get();
			existingCustomer.setAvatar(newCustomer.getAvatar());
			existingCustomer.setPhone(newCustomer.getPhone());
			existingCustomer.setNickname(newCustomer.getNickname());
			existingCustomer.setAccount(newCustomer.getAccount());
			existingCustomer.setAddress(newCustomer.getAddress());
			existingCustomer.setGender(newCustomer.getGender());
			existingCustomer.setName(newCustomer.getName());
			existingCustomer.setDob(newCustomer.getDob());
			customerRepository.save(existingCustomer);
			return existingCustomer;
		}
		return null;
	}

	@Override
	public Customer register(Account acc) {
		Customer newCustomer = new Customer();
		newCustomer.setAccount(acc);
		newCustomer.setAvatar("https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg");
		newCustomer.setPhone("");
		newCustomer.setNickname("Customer");
		newCustomer.setRole("customer");
		Customer registeredCustomer = customerRepository.save(newCustomer);

		return registeredCustomer;
	}
}