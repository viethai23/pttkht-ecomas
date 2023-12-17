package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.ProductDAO.ProductDAO;
import com.example.shoppingonline.Model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping
    public List<Product> getAllProducts() {
        return productDAO.getListProduct();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productDAO.getProductByName(keyword);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable int categoryId) {
        return productDAO.getProductByCategory(categoryId);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Product> getProductsByPrice(@PathVariable double maxPrice) {
        return productDAO.getProductByPrice(maxPrice);
    }
}
