package com.example.backendProject.service;

import com.example.backendProject.models.Category;
import com.example.backendProject.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product createProduct(Product p);
    Category getCategorybyId(Integer id);
}
