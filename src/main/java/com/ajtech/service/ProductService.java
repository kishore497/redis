package com.ajtech.service;

import com.ajtech.entity.Product;
import com.ajtech.repo.jpa.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @CacheEvict(value = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @CachePut(value = "products", key = "#id")
    public Product updateProduct(Long id, Product product) {
        // Ensure that the product exists in the DB before updating
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            product.setId(id); // Set the ID from the URL if it's a valid product
            return productRepository.save(product); // Save the updated product to DB
        } else {
            throw new RuntimeException("Product not found with ID: " + id); // Handle product not found
        }
    }
}

