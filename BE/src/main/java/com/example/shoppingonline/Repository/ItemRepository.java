package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Order.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByProduct_IdAndCart_Id(int productId, int cartId);
}
