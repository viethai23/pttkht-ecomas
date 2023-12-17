package com.example.shoppingonline.DAO.CategoryDAO;

import com.example.shoppingonline.Model.Product.Category;

import java.util.List;

import com.example.shoppingonline.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category getCategory(int categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		Category category = getCategory(categoryId);
		if (category != null) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

	@Override
	public List<Category> getListCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category editCategory(int categoryId, Category newCategory) {
		Category category = getCategory(categoryId);
		if (category != null) {
			category.setName(newCategory.getName());
			category.setDescription(newCategory.getDescription());
			return categoryRepository.save(category);
		}
		return null;
	}
}