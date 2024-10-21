package com.nimap.curd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimap.curd.model.Product;
import com.nimap.curd.repository.ProductRepository;

@Service
public class productService {
	@Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
       Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProd_name(product.getProd_name());
            existingProduct.setProd_price(product.getProd_price());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
