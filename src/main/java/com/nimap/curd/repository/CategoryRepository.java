package com.nimap.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.curd.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
