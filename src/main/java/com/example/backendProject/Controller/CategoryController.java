package com.example.backendProject.Controller;

import com.example.backendProject.Exception.CategoryNotFoundException;
import com.example.backendProject.Models.Category;
import com.example.backendProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CategoryController {
    private ProductService service;

    public CategoryController(@Qualifier("SelfProductService") ProductService inputService) {
        this.service = inputService;
    }
    @GetMapping("/Categories/{id}")
    public Category getCategorybyId(@PathVariable("id") Integer id) throws CategoryNotFoundException{
        Category category = service.getCategorybyId(id);
        if(category==null){
            throw new CategoryNotFoundException("Category not found");
        }
        return category;
    }
}
