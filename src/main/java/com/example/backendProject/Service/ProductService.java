package com.example.backendProject.Service;

import com.example.backendProject.Models.Category;
import com.example.backendProject.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product createProduct(Product p);
    Category getCategorybyId(Integer id);
}
