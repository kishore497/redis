package com.ajtech.service;

import com.ajtech.entity.Product;

import com.ajtech.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDAO;
    public Product save(Product product){
        return productDAO.save(product);
    }

    public List<Product> findAll(){
        return productDAO.findAll();
    }

    public Product findProductById(String id){
        return productDAO.findProductById(id);
    }

    public String delete(String id){
        return productDAO.deleteProduct(id);
    }
}
