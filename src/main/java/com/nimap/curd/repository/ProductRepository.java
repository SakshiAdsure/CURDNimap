package com.nimap.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.curd.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
