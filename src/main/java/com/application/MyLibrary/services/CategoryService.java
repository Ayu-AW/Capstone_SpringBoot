package com.application.MyLibrary.services;

import com.application.MyLibrary.data.CategoryRepository;
import com.application.MyLibrary.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method to fetch list of all Categories
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    // Method to get a specific category by id
    public Category findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        return category;
    }

    // Method to create category
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    // Method to update category
    public void updateCategory (Category category) {
        categoryRepository.save(category);
    }

    //Method to delete Category
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        categoryRepository.deleteById(category.getId());
    }


}
