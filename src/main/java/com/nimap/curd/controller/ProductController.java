package com.nimap.curd.controller;

import com.nimap.curd.model.Product;
import com.nimap.curd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")

public class ProductController {

	@Autowired
    private ProductRepository productRepository;

    //  GET all products (with optional pagination)
    @GetMapping
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        // For simplicity, we return all products without actual pagination
        return productRepository.findAll();
    }

    //  POST - Create a new product
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("Product added successfully!");
    }

    //  GET product by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(404).body("Product not found with id: " + id);
        }
    }

    //  PUT - Update product by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProd_name(productDetails.getProd_name());
            product.setProd_price(productDetails.getProd_price());
            productRepository.save(product);
            return ResponseEntity.ok("Product updated successfully!");
        } else {
            return ResponseEntity.status(404).body("Product not found with id: " + id);
        }
    }

    //  DELETE - Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Product not found with id: " + id);
        }
    }

}
