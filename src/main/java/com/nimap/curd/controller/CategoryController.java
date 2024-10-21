package com.nimap.curd.controller;

import com.nimap.curd.model.Category;
import com.nimap.curd.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
    private CategoryRepository categoryRepository;

    //  GET all categories 
    @GetMapping
    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        return categoryRepository.findAll();
    }

    //  POST - Create a new category
    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return ResponseEntity.ok("Category added successfully!");
    }

    //  GET category by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.status(404).body("Category not found with id: " + id);
        }
    }

    //  PUT - Update category by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setCate_name(categoryDetails.getCate_name());
            categoryRepository.save(category);
            return ResponseEntity.ok("Category updated successfully!");
        } else {
            return ResponseEntity.status(404).body("Category not found with id: " + id);
        }
    }

    // DELETE - Delete category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return ResponseEntity.ok("Category deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Category not found with id: " + id);
        }
    }
}
