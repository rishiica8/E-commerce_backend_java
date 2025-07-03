package com.example.backendProject.Service;

import com.example.backendProject.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product createProduct(String title, String imageURL, String catTitle, String description);
}
