package com.example.shoppingonline.DAO.ProductDAO;

import com.example.shoppingonline.Model.Product.Product;

import java.util.List;

public interface ProductDAO {
	List<Product> getListProduct();

	List<Product> getProductByName(String s);

	List<Product> getProductByCategory(int categoryId);

	List<Product> getProductByPrice(double p);

	Product getProduct(int productId);
	Product addProduct(Product product);

	Product editProduct(int productId, Product product);

}