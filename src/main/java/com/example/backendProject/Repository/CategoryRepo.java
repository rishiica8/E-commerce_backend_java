package com.example.backendProject.Repository;

import com.example.backendProject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Override
    Optional<Category> findById(Integer id);
    Optional<Category> findByTitle(String title);
}
