package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.CustomerDAO.CustomerDAO;
import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
        Customer customer = customerDAO.getCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
        if (customerDAO.deleteCustomer(customerId)) {
            return ResponseEntity.ok("Customer deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> editCustomer(@PathVariable int customerId, @RequestBody Customer newCustomer) {
        Customer editedCustomer = customerDAO.editCustomer(customerId, newCustomer);
        if (editedCustomer != null) {
            return ResponseEntity.ok(editedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Account acc) {
        Customer registeredCustomer = customerDAO.register(acc);
        if (registeredCustomer != null) {
            return ResponseEntity.ok(registeredCustomer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
