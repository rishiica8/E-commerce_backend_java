package com.example.backendProject.Repository;

import com.example.backendProject.Models.Category;
import com.example.backendProject.Models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
   Optional<Product> findById(Integer id);
   Product save(Product p);
   Optional<Product> findByCategory(Category c);
   List<Product> findAll();
   Optional<List<Product>> findAllByCategory(Category c);

}
