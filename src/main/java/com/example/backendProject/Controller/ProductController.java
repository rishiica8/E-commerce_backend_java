package com.example.backendProject.Controller;

import com.example.backendProject.Exception.ProductNotFoundException;
import com.example.backendProject.Models.Product;
import com.example.backendProject.Service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private FakeStoreProductService service;

    public ProductController(FakeStoreProductService inputService) {
        this.service = inputService;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product=service.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }

        return product;
    }
  public List<Product> getAllProducts() {
        List<Product> products=service.getAllProducts();
        return products;
  }
}
