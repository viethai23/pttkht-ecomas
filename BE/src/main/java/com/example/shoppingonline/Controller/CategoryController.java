package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.CategoryDAO.CategoryDAO;
import com.example.shoppingonline.Model.Product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryDAO.getListCategory();
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable int categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryDAO.addCategory(category);
    }

    @PutMapping("/{categoryId}")
    public Category editCategory(@PathVariable int categoryId, @RequestBody Category newCategory) {
        return categoryDAO.editCategory(categoryId, newCategory);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable int categoryId) {
        return categoryDAO.deleteCategory(categoryId);
    }
}
