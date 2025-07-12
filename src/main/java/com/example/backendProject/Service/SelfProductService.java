package com.example.backendProject.Service;

import com.example.backendProject.Models.Category;
import com.example.backendProject.Models.Product;
import com.example.backendProject.Repository.CategoryRepo;
import com.example.backendProject.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo,CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo= categoryRepo;
    }
    @Override
    public Product getProductById(Integer id){
      Optional<Product> response= productRepo.findById(id);
      if(!response.isPresent()){
          throw new IllegalArgumentException("Product not found");
      }
        return response.get();
    }
   @Override
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    @Override
    public Product createProduct(Product p){
       // Step1: validating input product
        // validateInputRequest(p);

        // Step2: creating product
        Product product =new Product();
        product.setTitle(p.getTitle());
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        product.setDescription(p.getDescription());
        product.setImageURL(p.getImageURL());

        // Step3: check if cat exists in the DB
       Optional <Category> existingCategory=categoryRepo.
                findByTitle(p.getCategory().getTitle());


        if (existingCategory.isEmpty()) {
            Category category = new Category();
            category.setTitle(p.getCategory().getTitle());
            product.setCategory(category);
        } else {
            product.setCategory(existingCategory.get());
        }

        // Step4: Finally save to the DB.
        Product response = productRepo.save(product);
        return response;
    }

    private void validateInputRequest(Product p) {
       if(p.getTitle() == null || p.getTitle().isEmpty()){
           throw new IllegalArgumentException("Title cannot be null");
       }
    }
}
