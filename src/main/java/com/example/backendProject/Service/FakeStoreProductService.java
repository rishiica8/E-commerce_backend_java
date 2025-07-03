package com.example.backendProject.Service;

import com.example.backendProject.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FakeStoreProductService implements com.example.backendProject.Service.ProductService {
    public Product getProductById(Integer id){
        return null;
    }

    public List<Product> getAllProducts(){
        return null;
    }

    public Product createProduct(String title, String imageURL, String catTitle, String description){
        return null;
    }
}
