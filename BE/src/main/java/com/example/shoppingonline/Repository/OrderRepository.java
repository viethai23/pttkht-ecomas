package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.User.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer(Customer customer);
}
