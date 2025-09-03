package com.example.backendProject.repository;

import com.example.backendProject.models.Category;
import com.example.backendProject.models.Product;
import com.example.backendProject.repository.Projection.ProductProjection;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {//(datatype of model, datatype of id)
   Optional<Product> findById(Integer id);
   Product save(Product p);
   Optional<Product> findByCategory(Category c);
   List<Product> findAll();
   Optional<List<Product>> findAllByCategory(Category c);
   void deleteById(Integer id);

// writing HQL
    @Query("select p.title from Product p where p.id=:id")
    ProductProjection getproductnamebyId(@Param("id") Integer id);
 //   @Query("select p.title,p.discription from Product p where p.id>10 )
 //  List<ProductProjection> getallproductsgreaterthanIdvalue(@Param("id") Integer id);

}
