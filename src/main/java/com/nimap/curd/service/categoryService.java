package com.nimap.curd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimap.curd.model.Category;
import com.nimap.curd.repository.CategoryRepository;

@Service
public class categoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category updateCategory(int id, Category category) {
		Category existingCategory = categoryRepository.findById(id).orElse(null);
		if (existingCategory != null) {
			existingCategory.setCate_name(category.getCate_name());
			return categoryRepository.save(existingCategory);
		}
		return null;
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

}
