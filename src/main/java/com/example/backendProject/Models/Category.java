package com.example.backendProject.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
@Getter
@Setter
@Entity
public class Category  extends  BaseModel implements Serializable {
    private String title;
    @OneToMany(mappedBy="category",cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Product> products;


}