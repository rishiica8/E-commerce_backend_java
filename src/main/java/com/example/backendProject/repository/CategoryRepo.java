package com.example.backendProject.repository;

import com.example.backendProject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Override
    //JPA query
    Optional<Category> findById(Integer id);
    Optional<Category> findByTitle(String title);
}
