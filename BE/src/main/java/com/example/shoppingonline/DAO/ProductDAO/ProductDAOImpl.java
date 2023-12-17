package com.example.shoppingonline.DAO.ProductDAO;

import com.example.shoppingonline.Model.Product.Category;
import com.example.shoppingonline.Model.Product.Product;

import java.util.Collections;
import java.util.List;

import com.example.shoppingonline.Repository.CategoryRepository;
import com.example.shoppingonline.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> getListProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByName(String name) {
		return productRepository.findByNameContaining(name);
	}

	@Override
	public List<Product> getProductByCategory(int categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category != null) {
			return productRepository.findByCategory(category);
		}
		return Collections.emptyList();
	}

	@Override
	public List<Product> getProductByPrice(double price) {
		return productRepository.findByPriceLessThanEqual(price);
	}

	@Override
	public Product getProduct(int productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(int bookId, Product product) {
		Product existingBook = getProduct(bookId);
		if (existingBook != null) {
			existingBook.setName(product.getName());
			existingBook.setDes(product.getDes());
			existingBook.setImage(product.getImage());
			existingBook.setStockQuantity(product.getStockQuantity());
			return productRepository.save(existingBook);
		}
		return null;
	}
}