package com.example.backendProject.Controller;

import com.example.backendProject.DTO.CreateProductRequestDTO;
import com.example.backendProject.Exception.ProductNotFoundException;
import com.example.backendProject.Models.Category;
import com.example.backendProject.Models.Product;
import com.example.backendProject.Service.FakeStoreProductService;
import com.example.backendProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService service;

    public ProductController(@Qualifier("SelfProductService") ProductService inputService) {
        this.service = inputService;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        if(id>500){
            throw new IllegalArgumentException("id should not be greater than 500");
        }
        Product product=service.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }

        return product;
    }
    @GetMapping("/Products")
  public List<Product> getAllProducts() {
        List<Product> products=service.getAllProducts();
        return products;
  }
  @PostMapping("/Products")
    public Product createProduct(@RequestBody CreateProductRequestDTO request) {
     Product product=service.createProduct( convertDTOtoProduct (request));
     return product;
  }
  private Product convertDTOtoProduct(CreateProductRequestDTO request){
        if(request==null){
            throw new IllegalArgumentException("request should not be null");
        }
        Product product=new Product();
      Category category=new Category();
      category.setTitle(request.getCategory().getTitle());
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setImageURL(request.getImageURL());
        product.setCategory(category);
        return product;
  }
}
