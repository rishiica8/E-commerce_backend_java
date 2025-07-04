package com.example.backendProject.Models;

import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.util.List;
@Getter
@Setter
public class Category  {
    private String Title;
    private List<Product> products;


}