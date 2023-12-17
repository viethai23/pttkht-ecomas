package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomer_IdAndStatus(int customerId, String status);
}
