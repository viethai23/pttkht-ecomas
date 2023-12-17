package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Product.Category;
import com.example.shoppingonline.Model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(Category category);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceLessThanEqual(double price);
}
